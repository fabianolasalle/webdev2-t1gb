package br.com.unilasalle.dao;

import br.com.unilasalle.entity.Disciplina;
import br.com.unilasalle.entity.Nota;
import br.com.unilasalle.entity.Professor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NotaDAO extends DefaultDAO {
    
    public String tablename = "nota";
    
    public NotaDAO() throws ClassNotFoundException{
        super();
    }
    
    public List<Nota> getAll() throws SQLException, ClassNotFoundException
    {
        String sql = "SELECT * FROM " + this.tablename;
        List<Nota> data = new ArrayList<Nota>();
        PreparedStatement stmt = this.getConnection().prepareStatement(sql);
        ResultSet resultSet = stmt.executeQuery();
        
        while (resultSet.next()) {
            Nota entity = new Nota(resultSet);
            
            DisciplinaDAO disciplinaDao = new DisciplinaDAO();
            entity.setDisciplina(disciplinaDao.getSingle(entity.getId_disciplina()));
            
            AlunoDAO alunoDao = new AlunoDAO();
            entity.setAluno(alunoDao.getSingle(entity.getId_aluno()));
            
            data.add(entity);
        }
        resultSet.close();
        stmt.close();
        
        return data;
    }
    
    public Nota getSingle(Long id) throws SQLException, ClassNotFoundException
    {
        String sql = "SELECT * FROM " + this.tablename + " WHERE id = ?";
        PreparedStatement stmt = this.getConnection().prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet resultSet = stmt.executeQuery();
        Nota entity = null;
        
        while (resultSet.next()) {
            entity = new Nota(resultSet);
        }
        
        return entity;
    }
    
    public Nota getByIdAlunoDisciplina(Long idAluno, Long idDisciplina) throws SQLException, ClassNotFoundException
    {
        String sql = "SELECT * FROM " + this.tablename + " WHERE id_aluno = ? AND id_disciplina = ?";
        PreparedStatement stmt = this.getConnection().prepareStatement(sql);
        stmt.setLong(1, idAluno);
        stmt.setLong(2, idDisciplina);
        ResultSet resultSet = stmt.executeQuery();
        Nota entity = null;
        
        while (resultSet.next()) {
            entity = new Nota(resultSet);
        }
        
        return entity;
    }
    
    public boolean update(Nota entity) throws SQLException
    {
        String sql = "UPDATE " + this.tablename + " SET "
                + "nota1 = ?, "
                + "nota2 = ?, "
                + "nota3 = ?, "
                + "id_disciplina = ?, "
                + "id_aluno = ? "
                + " WHERE id = ?";
        PreparedStatement stmt = this.getConnection().prepareStatement(sql);
        stmt.setFloat(1, entity.getNota1());
        stmt.setFloat(2, entity.getNota2());
        stmt.setFloat(3, entity.getNota3());
        stmt.setLong(4, entity.getId_disciplina());
        stmt.setLong(5, entity.getId_aluno());
        stmt.setLong(6, entity.getId());
        
        int result = stmt.executeUpdate();
        stmt.close();
        
        return result == 1;
    }
    
    public long insert(Nota entity) throws SQLException
    {
        String sql = "INSERT INTO " + this.tablename + " (nota1, nota2, nota3, id_disciplina, id_aluno) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = this.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setFloat(1, entity.getNota1());
        stmt.setFloat(2, entity.getNota2());
        stmt.setFloat(3, entity.getNota3());
        stmt.setLong(4, entity.getId_disciplina());
        stmt.setLong(5, entity.getId_aluno());
        
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