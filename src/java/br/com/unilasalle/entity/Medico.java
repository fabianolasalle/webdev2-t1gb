/*package br.com.lasalle.classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;

public class Medico implements ICrudEntity {
    public Long id;
    public Long idPessoa;
    public String crm;
    public Long idEspecialidade;
    public String horarioInicial;
    public String horarioFinal;
    public Pessoa pessoa;
    public Especialidade especialidade;

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Medico(ResultSet rs) throws SQLException
    {
        this.id = rs.getLong("id");
        this.idPessoa = rs.getLong("id_pessoa");
        this.crm = rs.getString("crm");
        this.idEspecialidade = rs.getLong("id_especialidade");
        this.horarioInicial = rs.getString("horario_inicial");
        this.horarioFinal = rs.getString("horario_final");
    }
    
    public Medico(HttpServletRequest request)
    {            
        this.mapRequest(request);
    }
    
    public Medico()
    {
        
    }
    
    public void mapRequest(HttpServletRequest request)
    {
        this.crm = request.getParameter("crm");
        this.idEspecialidade = Long.parseLong(request.getParameter("id_especialidade"));
        this.horarioInicial = request.getParameter("horario_inicial");
        this.horarioFinal = request.getParameter("horario_final");
    }
        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Long getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Long idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getHorarioInicial() {
        return horarioInicial;
    }
    
    public String getHorarioInicialHtml() {
        if (null == this.horarioInicial){
            return "";
        }
        return this.horarioInicial;
    }

    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }
    
    public String getHorarioFinalHtml() {
        if (null == this.horarioFinal){
            return "";
        }
        return this.horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }    
}
*/