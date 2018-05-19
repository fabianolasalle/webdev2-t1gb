/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unilasalle;

import br.com.unilasalle.dao.AlunoDAO;
import br.com.unilasalle.dao.DisciplinaDAO;
import br.com.unilasalle.dao.NotaDAO;
import br.com.unilasalle.dao.ProfessorDAO;
import br.com.unilasalle.entity.Aluno;
import br.com.unilasalle.entity.Disciplina;
import br.com.unilasalle.entity.Nota;
import br.com.unilasalle.entity.Professor;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author fabiano
 */
@Controller
public class ConsultaController {
        
    // @RequestMapping(value = "/bulletin/{id}", method = RequestMethod.GET)
    // public ModelAndView getSingleBulletin(@PathVariable("id") int id, Model model) 
    
    @RequestMapping(value = "/consulta", method = RequestMethod.GET)
    public String list(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        model.addAttribute("viewFile", "consulta/consulta.jsp");
        
        AlunoDAO alunoDao = new AlunoDAO();
        List<Aluno> alunos = alunoDao.getAll();
        model.addAttribute("alunos", alunos);

        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
        List<Disciplina> disciplinas = disciplinaDao.getAll();
        model.addAttribute("disciplinas", disciplinas);
        
        model.addAttribute("resultado", "");
        
        return "template";
    }

    @RequestMapping(value = "/consulta", method = RequestMethod.POST)
    public String savePost(@RequestParam("id_aluno") long idAluno, @RequestParam("id_disciplina") long idDisc, ModelMap model) throws ClassNotFoundException, SQLException {
        model.addAttribute("viewFile", "consulta/consulta.jsp");
        
        AlunoDAO alunoDao = new AlunoDAO();
        List<Aluno> alunos = alunoDao.getAll();
        model.addAttribute("alunos", alunos);

        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
        List<Disciplina> disciplinas = disciplinaDao.getAll();
        model.addAttribute("disciplinas", disciplinas);
        
        NotaDAO dao = new NotaDAO();
        Nota notas = dao.getByIdAlunoDisciplina(idAluno, idDisc);
        notas.getStatus();
        
        model.addAttribute("data", notas);

        return "template";
    }
    
}
