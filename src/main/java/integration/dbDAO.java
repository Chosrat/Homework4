/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integration;

/**
 *
 * @author Chosrat
 */

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import model.Currency;


@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class dbDAO {
    @PersistenceContext(unitName = "converterPU")
    private EntityManager em;


    public Currency findAccountByAcctNo(int currencyId) {
        Currency account = em.find(Currency.class, currencyId);
        if (account == null) {
            throw new EntityNotFoundException("No currency with number " + currencyId);
        }
        return account;
    }
    
}
