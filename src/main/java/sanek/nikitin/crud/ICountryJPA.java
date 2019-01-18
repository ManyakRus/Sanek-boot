/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanek.nikitin.crud;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sanek.nikitin.entity.Country;

/**
 *
 * @author Пользователь2
 */
public interface ICountryJPA extends JpaRepository<Country, String> {
    
    public ArrayList<Country> findTop3By();
    
    public Country findByCode(String code);
    
    
}
