/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sanek.nikitin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import sanek.nikitin.crud.IRoleJPA;
import sanek.nikitin.crud.IUserJPA;
import sanek.nikitin.entity.Role;
import sanek.nikitin.entity.User;

/**
 * @author Sanek
 * @date 25.01.2019 11:04:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSecurity {
    
    @Autowired
    IUserJPA userJPA;

    @Autowired
    IRoleJPA roleJPA;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void CreateUsers() {
        ArrayList<Role> list = (ArrayList) roleJPA.findAll();

        Role role;
//        try {
            role = roleJPA.findByName("ADMIN");
//        }
//        catch(NullPointerException e) {
//            role = new Role();
//            role.setName("admin");
//            role.getUserSet().add(user);
//            roleJPA.saveAndFlush(role);
//
//            
//            role = roleJPA.findByName("ADMIN");
//        }

//        if (role == null) {
//        }
        
            HashSet<Role> roleSet = new HashSet<Role>();
            roleSet.add(role);
            
        User user = userJPA.findByName("admin");
        if (1==1) {
            String password = "1";
            String passwordCrypt = bCryptPasswordEncoder.encode(password);
            
            
            
            //user = new User();
            user.setName("admin");
            user.setRoleSet(roleSet);
            user.setPassword(passwordCrypt);
            user.setEnabled(true);
            userJPA.saveAndFlush(user);
        }
        
//        Role role = roleJPA.findByName("ADMIN");
//            role.setName("admin");
//            role.getUserSet().add(user);
//            roleJPA.saveAndFlush(role);
            
        
        
    }
}
