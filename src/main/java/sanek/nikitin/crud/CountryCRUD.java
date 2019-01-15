/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanek.nikitin.crud;

import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sanek.nikitin.entity.Country;

/**
 *
 * @author Пользователь2
 */
@Transactional
@Component
public class CountryCRUD{
    @Autowired
    ICountryCRUD iCountryCRUD;

    public ArrayList<Country> findAll() {
        return iCountryCRUD.findTop10By();
    }

    public Country findByCode(String code) {
        return iCountryCRUD.findByCode(code);
    }
    
}
