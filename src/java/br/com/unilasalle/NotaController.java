/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unilasalle;

import br.com.unilasalle.dao.AlunoDAO;
import br.com.unilasalle.dao.DisciplinaDAO;
import br.com.unilasalle.dao.NotaDAO;
import br.com.unilasalle.entity.Aluno;
import br.com.unilasalle.entity.Disciplina;
import br.com.unilasalle.entity.Nota;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author fabiano
 */
@Controller
public class NotaController {
        
    // @RequestMapping(value = "/bulletin/{id}", method = RequestMethod.GET)
    // public ModelAndView getSingleBulletin(@PathVariable("id") int id, Model model) 
    
    @RequestMapping(value = "/nota/list", method = RequestMethod.GET)
    public String list(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        model.addAttribute("viewFile", "nota/list.jsp");
        
        NotaDAO dao = new NotaDAO();
        model.addAttribute("data", dao.getAll());
        return "template";
    }

    @RequestMapping(value = "/nota/save", method = RequestMethod.GET)
    public String save(ModelMap model) throws ClassNotFoundException, SQLException {
        model.addAttribute("viewFile", "nota/save.jsp");
        
        AlunoDAO alunoDao = new AlunoDAO();
        List<Aluno> alunos = alunoDao.getAll();
        model.addAttribute("alunos", alunos);

        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
        List<Disciplina> disciplinas = disciplinaDao.getAll();
        model.addAttribute("disciplinas", disciplinas);
        
        return "template";
    }
    
    @RequestMapping(value = "/nota/save/{id}", method = RequestMethod.GET)
    public String save(@PathVariable("id") long id, ModelMap model) throws ClassNotFoundException, SQLException {
        NotaDAO dao = new NotaDAO();
        Nota entity = dao.getSingle(id);
        
        AlunoDAO alunoDao = new AlunoDAO();
        List<Aluno> alunos = alunoDao.getAll();
        model.addAttribute("alunos", alunos);

        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
        List<Disciplina> disciplinas = disciplinaDao.getAll();
        model.addAttribute("disciplinas", disciplinas);
                
        model.addAttribute("data", entity);
        model.addAttribute("viewFile", "nota/save.jsp");
        
        return "template";
    }
    
    @RequestMapping(value = "/nota/save", method = RequestMethod.POST)
    public String savePost(Nota entity) throws ClassNotFoundException, SQLException {
         NotaDAO dao = new NotaDAO();
        
        if (entity.getId() > 0) {
            dao.update(entity);
        } else {
            dao.insert(entity);
        }
        
        return "redirect:/nota/list";
    }
    
    @RequestMapping(value = "/nota/remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") long id, ModelMap model) throws ClassNotFoundException, SQLException {
        NotaDAO dao = new NotaDAO(); 
        dao.remove(id);
        
        return "redirect:/nota/list";
    }
}
