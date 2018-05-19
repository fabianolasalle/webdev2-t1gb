/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unilasalle;

import br.com.unilasalle.dao.DisciplinaDAO;
import br.com.unilasalle.dao.ProfessorDAO;
import br.com.unilasalle.entity.Disciplina;
import br.com.unilasalle.entity.Professor;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author fabiano
 */
@Controller
public class DisciplinaController {
        
    // @RequestMapping(value = "/bulletin/{id}", method = RequestMethod.GET)
    // public ModelAndView getSingleBulletin(@PathVariable("id") int id, Model model) 
    
    @RequestMapping(value = "/disciplina/list", method = RequestMethod.GET)
    public String list(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        model.addAttribute("viewFile", "disciplina/list.jsp");
        
        DisciplinaDAO dao = new DisciplinaDAO();
        model.addAttribute("data", dao.getAll());
        return "template";
    }

    @RequestMapping(value = "/disciplina/save", method = RequestMethod.GET)
    public String save(ModelMap model) throws ClassNotFoundException, SQLException {
        model.addAttribute("viewFile", "disciplina/save.jsp");
        
        ProfessorDAO profDao = new ProfessorDAO();
        List<Professor> professores = profDao.getAll();
        
        model.addAttribute("professores", professores);
        
        return "template";
    }
    
    @RequestMapping(value = "/disciplina/save/{id}", method = RequestMethod.GET)
    public String save(@PathVariable("id") long id, ModelMap model) throws ClassNotFoundException, SQLException {
        DisciplinaDAO dao = new DisciplinaDAO();
        Disciplina entity = dao.getSingle(id);
        
        ProfessorDAO profDao = new ProfessorDAO();
        List<Professor> professores = profDao.getAll();
        
        model.addAttribute("professores", professores);
        
        model.addAttribute("data", entity);
        model.addAttribute("viewFile", "disciplina/save.jsp");
        
        return "template";
    }
    
    @RequestMapping(value = "/disciplina/save", method = RequestMethod.POST)
    public String savePost(Disciplina entity) throws ClassNotFoundException, SQLException {
         DisciplinaDAO dao = new DisciplinaDAO();
        
        if (entity.getId() > 0) {
            dao.update(entity);
        } else {
            dao.insert(entity);
        }
        
        return "redirect:/disciplina/list";
    }
    
    @RequestMapping(value = "/disciplina/remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") long id, ModelMap model) throws ClassNotFoundException, SQLException {
        DisciplinaDAO dao = new DisciplinaDAO(); 
        dao.remove(id);
        
        return "redirect:/disciplina/list";
    }
}
