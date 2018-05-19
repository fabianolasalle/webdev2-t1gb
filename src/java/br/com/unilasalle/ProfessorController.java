/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unilasalle;

import br.com.unilasalle.dao.ProfessorDAO;
import br.com.unilasalle.entity.Professor;
import java.sql.SQLException;
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
public class ProfessorController {
        
    // @RequestMapping(value = "/bulletin/{id}", method = RequestMethod.GET)
    // public ModelAndView getSingleBulletin(@PathVariable("id") int id, Model model) 
    
    @RequestMapping(value = "/professor/list", method = RequestMethod.GET)
    public String list(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        model.addAttribute("viewFile", "professor/list.jsp");
        
        ProfessorDAO dao = new ProfessorDAO();
        model.addAttribute("data", dao.getAll());
        return "template";
    }

    @RequestMapping(value = "/professor/save", method = RequestMethod.GET)
    public String save(ModelMap model) {
        model.addAttribute("viewFile", "professor/save.jsp");
        
        return "template";
    }
    
    @RequestMapping(value = "/professor/save/{id}", method = RequestMethod.GET)
    public String save(@PathVariable("id") long id, ModelMap model) throws ClassNotFoundException, SQLException {
        ProfessorDAO dao = new ProfessorDAO();
        Professor entity = dao.getSingle(id);
        
        model.addAttribute("data", entity);
        model.addAttribute("viewFile", "professor/save.jsp");
        
        return "template";
    }
    
    @RequestMapping(value = "/professor/save", method = RequestMethod.POST)
    public String savePost(Professor entity) throws ClassNotFoundException, SQLException {
        ProfessorDAO dao = new ProfessorDAO();
        
        if (entity.getId() > 0) {
            dao.update(entity);
        } else {
            dao.insert(entity);
        }
        
        return "redirect:/professor/list";
    }
    
    @RequestMapping(value = "/professor/remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") long id, ModelMap model) throws ClassNotFoundException, SQLException {
        ProfessorDAO dao = new ProfessorDAO(); 
        dao.remove(id);
        
        return "redirect:/professor/list";
    }
}
