/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Chosrat
 */

import controller.Controller;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.CurrencyDTO;


/**
 * Handles all interaction with the account JSF page.
 */
@Named("converterManager")
@ConversationScoped
public class ConvertManager implements Serializable {
    @EJB
    private Controller cashierFacade;
    private CurrencyDTO currentAcct;
    private Integer searchCurrencyId;
    private Exception transactionFailure;
    private double amountToConvert;
    private double convertedAmount;
    @Inject
    private Conversation conversation;


    private void startConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    private void stopConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }


    public void findAccount() {
            startConversation();
            transactionFailure = null;
            currentAcct = cashierFacade.findAccount(searchCurrencyId);

    }

    public void setAmountToConvert(double amountToConvert) {
        this.amountToConvert = amountToConvert;
    }

    public double getAmountToConvert() {
        return amountToConvert;
    }
    
    public void convertAmount(){
        findAccount();
        System.out.println(currentAcct.getValue());
        convertedAmount = cashierFacade.convert(amountToConvert, currentAcct.getValue());
    }

    public void setConvertedAmount(long convertedAmount) {
        this.convertedAmount = convertedAmount;
    }

    public double getConvertedAmount() {
        return convertedAmount;
    }

    public void setCurrentAcct(CurrencyDTO currentAcct) {
        this.currentAcct = currentAcct;
    }
    
    
    public void setSearchCurrencyId(Integer searchCurrencyId) {
        this.searchCurrencyId = searchCurrencyId;
    }

    public Integer getSearchCurrencyId() {
        return searchCurrencyId;
    }

    public CurrencyDTO getCurrentAcct() {
        return currentAcct;
    }
}