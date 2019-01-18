/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanek.nikitin.crud;

import java.util.ArrayList;
import sanek.nikitin.entity.Country;

/**
 *
 * @author Пользователь2
 */
public interface ICountryCRUD {

    ArrayList<Country> findAll();

    Country findByCode(String code);
    
}
