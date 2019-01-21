/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sanek.nikitin.webController;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sanek.nikitin.crud.CountryCRUD;
import sanek.nikitin.entity.Country;

/**
 * @author Sanek
 * @date 21.01.2019 11:03:19
 */
@RestController
public class WebRestController {

    @Autowired
    CountryCRUD countryCrud;
    
    @GetMapping(name="country", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Country getCountry(@RequestParam String code, HttpServletResponse response) {
        Country country = countryCrud.findByCode(code);
        response.setStatus(HttpServletResponse.SC_OK);
        return country;
    }
    
}
