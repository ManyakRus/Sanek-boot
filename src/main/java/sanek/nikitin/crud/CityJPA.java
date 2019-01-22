/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sanek.nikitin.crud;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sanek.nikitin.entity.City;

/**
 * @author Sanek
 * @date 22.01.2019 13:58:49
 */
@RepositoryRestResource(path = "city")
public interface CityJPA extends JpaRepository<City, Integer> {
    
    
}
