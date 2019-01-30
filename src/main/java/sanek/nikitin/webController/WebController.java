package sanek.nikitin.webController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sanek.nikitin.crud.CountryCRUD;
import sanek.nikitin.crud.IRoleJPA;
import sanek.nikitin.crud.IUserJPA;
import sanek.nikitin.entity.Role;
import sanek.nikitin.entity.User;
import sanek.nikitin.jms.Consumer;
import sanek.nikitin.jms.Producer;
import sanek.nikitin.model.Person;
 
@Controller
@ComponentScan
public class WebController {
 
    private static List<Person> persons = new ArrayList<Person>();
    
    @Autowired
    CountryCRUD countryCRUD;
    
    @Autowired
    Producer producer;
 
    @Autowired
    Consumer consumer;
    
    @Autowired
    IUserJPA userJPA;
    
    @Autowired
    IRoleJPA roleJPA;
 
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    static {
        persons.add(new Person("Bill", "Gates"));
        persons.add(new Person("Steve", "Jobs"));
    }
 
    @RequestMapping(value ="/", method = RequestMethod.GET)
    public ModelAndView index(Authentication authentication) {
 
        ModelAndView mav = new ModelAndView();
        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            Collection<? extends GrantedAuthority> list = userDetails.getAuthorities();
            String roles = "";
            for (GrantedAuthority l : list) {
                roles = roles + l.toString() + "<BR/>";
            }

            //mav.setViewName("admin");
            mav.addObject("login", userDetails.getUsername());
            mav.addObject("roles", roles);
        }

        String message = "Hello Spring Boot + JSP";

        mav.addObject("list", countryCRUD.findAll());
        mav.addObject("message", message);
        mav.setViewName("index");

        return mav;
    }
 
    @Secured("ADMIN")
    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String viewPersonList(Model model) {
 
        model.addAttribute("persons", persons);
 
        return "personList";
    }
 
    @GetMapping("/sendJMS" )
    public String sendJMS() {
 
        producer.send("Hello " + LocalDateTime.now());
        
        return "sendJMS";
    }
 
    @GetMapping("/showJMS" )
    public ModelAndView showJMS() {
 
        String mess = consumer.getAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("mess", mess);
        
        return mav;
    }
 
    @GetMapping("/admin" )
    public ModelAndView admin(Authentication authentication) {
 
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> list = userDetails.getAuthorities();
        String roles = "";
        for (GrantedAuthority l:list) {
            roles = roles + l.toString() + "<BR/>";
        }
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("admin");
        mav.addObject("login", userDetails.getUsername());
        mav.addObject("roles", roles);
        
        return mav;
    }
 
    @GetMapping("/login" )
    public ModelAndView login(Authentication authentication, User user) {
 
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        mav.addObject("user", user);
        
        return mav;
    }
 
    @PostMapping("/login" )
    public ModelAndView loginPost(Authentication authentication, User user) {
 
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/");
        
        return mav;
    }
 
    @GetMapping("/registration" )
    public ModelAndView registration(User user) {

        //User user = new User();
        
        ModelAndView mav = new ModelAndView();
        mav.setViewName("registration");
        mav.addObject("user", user);
        
        return mav;
    }
 
    @PostMapping("/registration" )
    public ModelAndView registrationPost(ModelMap model, 
                                        @RequestParam String name,
                                        @RequestParam String password,
                                        User user) {

        ModelAndView mav = new ModelAndView();
        User newUser = userJPA.findByName(user.getName());
        if (newUser == null) {
            Role role = roleJPA.findByName("USER");
            
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.getRoleSet().clear();
            user.getRoleSet().add(role);
            user.setEnabled(true);
            userJPA.saveAndFlush(user);
            
            mav.setViewName("index");
        }
        else {
            
            mav.setViewName("registration");
        }
        
        //mav.addObject("user", user);
        
        return mav;
    }
 
}
