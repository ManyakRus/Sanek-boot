/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sanek.nikitin.Service;

import java.util.Arrays;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sanek.nikitin.crud.IRoleJPA;
import sanek.nikitin.crud.IUserJPA;
import sanek.nikitin.entity.Role;
import sanek.nikitin.entity.User;

/**
 * @author Sanek
 * @date 24.01.2019 14:16:45
 */
@Service("userService")
public class UserService {

    private IUserJPA userJPA;
    private IRoleJPA roleJPA;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(IUserJPA userJPA,
                       IRoleJPA roleJPA,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userJPA = userJPA;
        this.roleJPA = roleJPA;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User findUserByName(String name) {
        return userJPA.findByName(name);
    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleJPA.findByName("ADMIN");
        user.setRoleSet(new HashSet<Role>(Arrays.asList(userRole)));
        userJPA.save(user);
    }

}
