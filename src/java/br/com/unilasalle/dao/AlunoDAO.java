package br.com.unilasalle.dao;

import br.com.unilasalle.entity.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends DefaultDAO {
    
    public String tablename = "aluno";
    
    public AlunoDAO() throws ClassNotFoundException{
        super();
    }
    
    public List<Aluno> getAll() throws SQLException, ClassNotFoundException
    {
        String sql = "SELECT * FROM " + this.tablename;
        List<Aluno> data = new ArrayList<Aluno>();
        PreparedStatement stmt = this.getConnection().prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();
        
        while (resultSet.next()) {
            Aluno entity = new Aluno(resultSet);            
            data.add(entity);
        }
        resultSet.close();
        stmt.close();
        
        return data;
    }
    
    public Aluno getSingle(Long id) throws SQLException, ClassNotFoundException
    {
        String sql = "SELECT * FROM " + this.tablename + " WHERE id = ?";
        PreparedStatement stmt = this.getConnection().prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet resultSet = stmt.executeQuery();
        Aluno entity = null;
        
        while (resultSet.next()) {
            entity = new Aluno(resultSet);
        }
        
        return entity;
    }
    
    public boolean update(Aluno entity) throws SQLException
    {
        String sql = "UPDATE " + this.tablename + " SET "
                + "nome = ?, "
                + "telefone = ?, "
                + "endereco = ?, "
                + "matricula = ?, "
                + "cpf = ?, "
                + "email = ? "
                + " WHERE id = ?";
        PreparedStatement stmt = this.getConnection().prepareStatement(sql);
        stmt.setString(1, entity.getNome());
        stmt.setString(2, entity.getTelefone());
        stmt.setString(3, entity.getEndereco());
        stmt.setString(4, entity.getMatricula());
        stmt.setString(5, entity.getCpf());
        stmt.setString(6, entity.getEmail());
        stmt.setLong(7, entity.getId());
        
        int result = stmt.executeUpdate();
        stmt.close();
        
        return result == 1;
    }
    
    public long insert(Aluno entity) throws SQLException
    {
        String sql = "INSERT INTO " + this.tablename + " (nome, telefone, endereco, email, matricula, cpf) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = this.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, entity.getNome());
        stmt.setString(2, entity.getTelefone());
        stmt.setString(3, entity.getEndereco());
        stmt.setString(4, entity.getEmail());
        stmt.setString(5, entity.getMatricula());
        stmt.setString(6, entity.getCpf());
        
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