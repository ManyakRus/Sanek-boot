/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sanek.nikitin.webController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sanek.nikitin.crud.CountryCRUD;
import sanek.nikitin.entity.Country;
import sanek.nikitin.imodel.ICountry;
import sanek.nikitin.modelError.CountryError;

/**
 * @author Sanek
 * @date 21.01.2019 11:03:19
 */
@RestController
public class WebRestController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CountryCRUD countryCrud;
    
    @GetMapping(value="/countryjson", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String getCountry(@RequestParam String code, HttpServletResponse response) {
        
        Country country = countryCrud.findByCode(code);
//        CountryError countryError = new CountryError();
//        countryError.setCode(code);
//        countryError.setErrorMessage("error message");
//        
//        ICountry country = (ICountry) countryError;
//        
//        response.setStatus(HttpServletResponse.SC_OK);

        ObjectMapper mapper = new ObjectMapper();
        String result = "";
        try {
            result = mapper.writeValueAsString(country);
        } catch (JsonProcessingException ex) {
            logger.error("" + ex);
        }
        logger.info("json:\n" + result);
        
        return result;
    }
    
}
