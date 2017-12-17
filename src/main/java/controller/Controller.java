/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import integration.dbDAO;

/**
 *
 * @author Chosrat
 */

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import model.Converter;
import model.CurrencyDTO;


@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class Controller {
    @EJB dbDAO bankDB;
    
    Converter converter = new Converter();


    public CurrencyDTO findAccount(int currencyId) {
        return bankDB.findAccountByAcctNo(currencyId);
    }
    
    public double convert(double amountToConvert, double rateChange){
        System.out.println(amountToConvert);
        System.out.println(rateChange);
        return converter.convertAmount(amountToConvert, rateChange);
    }

}
