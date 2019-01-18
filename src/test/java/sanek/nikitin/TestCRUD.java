/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanek.nikitin;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sanek.nikitin.crud.CountryCRUD;
import sanek.nikitin.crud.ICountryCRUD;
import sanek.nikitin.entity.Country;
import sanek.nikitin.crud.ICountryJPA;

/**
 * @author Пользователь2
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCRUD {

    @Autowired
    CountryCRUD countryCRUD;
    
    @Mock
    CountryCRUD countryCRUD_mock;
    
    @Test
    public void findAll() {
        System.out.println("countryCRUD: " + countryCRUD);
        List<Country> list = countryCRUD.findAll();
        for (Country c: list) {
            System.out.println("Country: " + c);
        }
        
    }

    @Test
    public void findAll_mock() {
        System.out.println("countryCRUD_mock: " + countryCRUD_mock);
        List<Country> list = countryCRUD_mock.findAll();
        for (Country c: list) {
            System.out.println("Country: " + c);
        }
        
    }

}
