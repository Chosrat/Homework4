/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Chosrat
 */

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A persistent representation of an account.
 */
@Entity
public class Currency implements CurrencyDTO, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double value;
    private String currencyName;


    public Currency() {
    }


    public Currency(double value, String currencyName) {
        this.value = value;
        this.currencyName = currencyName;
    }

    @Override
    public int getId() {
        return id;
    }
        
    @Override
    public double getValue() {
    return value;
    }

    @Override
    public String getCurrencyName() {
    return currencyName;
    }
     
    @Override
    public int hashCode() {
        int hash = 0;
        return new Integer(id).hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Currency[id=" + id + "]";
    }

}
