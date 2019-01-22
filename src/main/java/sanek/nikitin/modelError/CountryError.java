/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sanek.nikitin.modelError;

import lombok.Data;
import sanek.nikitin.imodel.ICountry;

/**
 * @author Sanek
 * @date 22.01.2019 11:21:53
 */
//@Data
public class CountryError implements ICountry{
    private String code;
    private String errorMessage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    
    
}
