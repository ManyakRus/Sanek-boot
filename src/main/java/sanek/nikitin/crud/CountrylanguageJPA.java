/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sanek.nikitin.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import sanek.nikitin.entity.Countrylanguage;
import sanek.nikitin.entity.CountrylanguagePK;

/**
 *
 * @author Sanek
 * @date 22.01.2019 14:41:09
 */
public interface CountrylanguageJPA  extends JpaRepository<Countrylanguage, CountrylanguagePK>{

}
