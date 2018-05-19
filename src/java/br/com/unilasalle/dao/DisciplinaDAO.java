package br.com.unilasalle.dao;

import br.com.unilasalle.entity.Disciplina;
import br.com.unilasalle.entity.Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO extends DefaultDAO {
    
    public String tablename = "disciplina";
    
    public DisciplinaDAO() throws ClassNotFoundException{
        super();
    }
    
    public List<Disciplina> getAll() throws SQLException, ClassNotFoundException
    {
        String sql = "SELECT * FROM " + this.tablename;
        List<Disciplina> data = new ArrayList<Disciplina>();
        PreparedStatement stmt = this.getConnection().prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();
        
        while (resultSet.next()) {
            Disciplina entity = new Disciplina(resultSet);            
            data.add(entity);
        }
        resultSet.close();
        stmt.close();
        
        return data;
    }
    
    public Disciplina getSingle(Long id) throws SQLException, ClassNotFoundException
    {
        String sql = "SELECT * FROM " + this.tablename + " WHERE id = ?";
        PreparedStatement stmt = this.getConnection().prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet resultSet = stmt.executeQuery();
        Disciplina entity = null;
        
        while (resultSet.next()) {
            entity = new Disciplina(resultSet);
        }
        
        return entity;
    }
    
    public boolean update(Disciplina entity) throws SQLException
    {
        String sql = "UPDATE " + this.tablename + " SET "
                + "nome = ?, "
                + "codigo = ?, "
                + "id_professor = ?, "
                + "cargaHoraria = ? "
                + " WHERE id = ?";
        PreparedStatement stmt = this.getConnection().prepareStatement(sql);
        stmt.setString(1, entity.getNome());
        stmt.setString(2, entity.getCodigo());
        stmt.setLong(3, entity.getId_professor());
        stmt.setLong(4, entity.getCargaHoraria());
        stmt.setLong(5, entity.getId());
        
        int result = stmt.executeUpdate();
        stmt.close();
        
        return result == 1;
    }
    
    public long insert(Disciplina entity) throws SQLException
    {
        String sql = "INSERT INTO " + this.tablename + " (nome, codigo, id_professor, cargaHoraria) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = this.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, entity.getNome());
        stmt.setString(2, entity.getCodigo());
        stmt.setLong(3, entity.getId_professor());
        stmt.setLong(4, entity.getCargaHoraria());
        
        int result = stmt.executeUpdate();
        
        long insertedIdResult = 0l;
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()){
            insertedIdResult = rs.getInt(1);
        }
        stmt.close();
        
        return insertedIdResult;
    }
    
    public boolean remove(long id) throws SQLException
    {
        String sql = "DELETE FROM " + this.tablename + " WHERE id = ?";
        PreparedStatement stmt = this.getConnection().prepareStatement(sql);
        stmt.setLong(1, id);
        int result = stmt.executeUpdate();
        stmt.close();
        
        return result == 1;
    }
}