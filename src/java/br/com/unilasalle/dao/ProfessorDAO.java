package br.com.unilasalle.dao;

import br.com.unilasalle.entity.Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO extends DefaultDAO {
    
    public String tablename = "professor";
    
    public ProfessorDAO() throws ClassNotFoundException{
        super();
    }
    
    public List<Professor> getAll() throws SQLException, ClassNotFoundException
    {
        String sql = "SELECT * FROM " + this.tablename;
        List<Professor> data = new ArrayList<Professor>();
        PreparedStatement stmt = this.getConnection().prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();
        
        while (resultSet.next()) {
            Professor entity = new Professor(resultSet);            
            data.add(entity);
        }
        resultSet.close();
        stmt.close();
        
        return data;
    }
    
    public Professor getSingle(Long id) throws SQLException, ClassNotFoundException
    {
        String sql = "SELECT * FROM " + this.tablename + " WHERE id = ?";
        PreparedStatement stmt = this.getConnection().prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet resultSet = stmt.executeQuery();
        Professor entity = null;
        
        while (resultSet.next()) {
            entity = new Professor(resultSet);
        }
        
        return entity;
    }
    
    public boolean update(Professor entity) throws SQLException
    {
        String sql = "UPDATE " + this.tablename + " SET "
                + "nome = ?, "
                + "telefone = ?, "
                + "endereco = ?, "
                + "registro = ?, "
                + "cpf = ?, "
                + "email = ?,"
                + "salario = ? "
                + " WHERE id = ?";
        PreparedStatement stmt = this.getConnection().prepareStatement(sql);
        stmt.setString(1, entity.getNome());
        stmt.setString(2, entity.getTelefone());
        stmt.setString(3, entity.getEndereco());
        stmt.setString(4, entity.getRegistro());
        stmt.setString(5, entity.getCpf());
        stmt.setString(6, entity.getEmail());
        stmt.setFloat(7, entity.getSalario());
        stmt.setLong(8, entity.getId());
        
        int result = stmt.executeUpdate();
        stmt.close();
        
        return result == 1;
    }
    
    public long insert(Professor entity) throws SQLException
    {
        String sql = "INSERT INTO " + this.tablename + " (nome, telefone, endereco, email, registro, cpf, salario) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = this.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, entity.getNome());
        stmt.setString(2, entity.getTelefone());
        stmt.setString(3, entity.getEndereco());
        stmt.setString(4, entity.getEmail());
        stmt.setString(5, entity.getRegistro());
        stmt.setString(6, entity.getCpf());
        stmt.setFloat(7, entity.getSalario());
        
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