/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.unilasalle;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String list(ModelMap model, HttpServletRequest request) {
        model.addAttribute("viewFile", "aluno/list.jsp");
        return "template";
    }
    
    @RequestMapping(value = "/aluno/save", method = RequestMethod.GET)
    public String save(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "ok";
    }
    
    @RequestMapping(value = "/aluno/remove", method = RequestMethod.GET)
    public String remove(ModelMap model) {
        model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
        return "ok";
    }
}
