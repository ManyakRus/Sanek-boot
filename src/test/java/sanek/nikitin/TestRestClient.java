/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sanek.nikitin;

import java.util.Arrays;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import sanek.nikitin.entity.Country;

/**
 * @author Sanek
 * @date 23.01.2019 10:50:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRestClient {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    public String URL_SERVER = "http://localhost:8080";
    public String URL_COUNTRY = "/countryjson?code=rus";
    
    @Autowired
    RestTemplate restTemplate;
    
    @Test
    public void TestGet() {
        // HttpHeaders
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        // Request to return JSON format
        headers.setContentType(MediaType.APPLICATION_JSON);
        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        
        //RestTemplate restTemplate = new RestTemplate();
 
        // Send request with GET method and default Headers.
        ResponseEntity<Country> response = restTemplate.exchange(URL_SERVER + URL_COUNTRY, HttpMethod.GET, entity, Country.class);
//        String result = restTemplate.getForObject(URL_SERVER + URL_COUNTRY, String.class);
 
        Country result = response.getBody();
        log.warn("\n\nREST country:\n" + result + "\n");
        
        HttpStatus statusCode = response.getStatusCode();
        log.warn("%green Http status: " + statusCode + "\n");
        
        assertTrue(!"".equals(result));
    }
}
