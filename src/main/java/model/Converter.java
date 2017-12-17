/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Chosrat
 */
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class Converter {

    public Converter() {
    }
    
    public double convertAmount(double amountToConvert, double convertRate){
        return (amountToConvert * convertRate);
    }
    
}
