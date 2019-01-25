/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sanek.nikitin.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import sanek.nikitin.entity.Role;
import sanek.nikitin.entity.User;

/**
 *
 * @author Sanek
 * @date 25.01.2019 12:35:08
 */
public interface IUserJPA extends JpaRepository<User, Long> {
    public User findByName(String name);
}
