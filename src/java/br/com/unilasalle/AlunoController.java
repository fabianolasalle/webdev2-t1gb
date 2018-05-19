/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unilasalle;

import br.com.unilasalle.entity.Aluno;
import br.com.unilasalle.dao.AlunoDAO;
import java.sql.SQLException;
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
public class AlunoController {

    // @RequestMapping(value = "/bulletin/{id}", method = RequestMethod.GET)
    // public ModelAndView getSingleBulletin(@PathVariable("id") int id, Model model) 
    
    @RequestMapping(value = "/aluno/list", method = RequestMethod.GET)
    public String list(ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
        model.addAttribute("viewFile", "aluno/list.jsp");
        
        AlunoDAO dao = new AlunoDAO();
        model.addAttribute("data", dao.getAll());
        return "template";
    }

    @RequestMapping(value = "/aluno/save", method = RequestMethod.GET)
    public String save(ModelMap model) {
        model.addAttribute("viewFile", "aluno/save.jsp");
        
        return "template";
    }
    
    @RequestMapping(value = "/aluno/save/{id}", method = RequestMethod.GET)
    public String save(@PathVariable("id") long id, ModelMap model) throws ClassNotFoundException, SQLException {
        AlunoDAO dao = new AlunoDAO();
        Aluno entity = dao.getSingle(id);
        
        model.addAttribute("data", entity);
        model.addAttribute("viewFile", "aluno/save.jsp");
        
        return "template";
    }
    
    @RequestMapping(value = "/aluno/save", method = RequestMethod.POST)
    public String savePost(Aluno entity) throws ClassNotFoundException, SQLException {
        AlunoDAO dao = new AlunoDAO();
        
        if (entity.getId() > 0) {
            dao.update(entity);
        } else {
            dao.insert(entity);
        }
        
        return "redirect:/aluno/list";
    }
    
    @RequestMapping(value = "/aluno/remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") long id, ModelMap model) throws ClassNotFoundException, SQLException {
        AlunoDAO dao = new AlunoDAO(); 
        dao.remove(id);
        
        return "redirect:/aluno/list";
    }
}
