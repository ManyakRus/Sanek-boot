package sanek.nikitin.webController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sanek.nikitin.crud.CountryCRUD;
import sanek.nikitin.model.Person;
 
@Controller
@ComponentScan
public class WebController {
 
    private static List<Person> persons = new ArrayList<Person>();
    
    @Autowired
    CountryCRUD countryCRUD;
 
    static {
        persons.add(new Person("Bill", "Gates"));
        persons.add(new Person("Steve", "Jobs"));
    }
 
    @RequestMapping(value ="/", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView mav) {
 
        String message = "Hello Spring Boot + JSP";
 
        mav.addObject("list", countryCRUD.findAll());
        mav.addObject("message", message);
        mav.setViewName("index");
 
        return mav;
    }
 
    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String viewPersonList(Model model) {
 
        model.addAttribute("persons", persons);
 
        return "personList";
    }
 
}
