/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingApp.contacts.Address;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

/**
 *
 * @author minon
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class Address implements Serializable{
    
    private String unitNumber;
    private String streetName;
    private int postalCode;

    public Address() {
    }

    public Address(String unitNumber, String streetName, int postalCode) {
        this.unitNumber = unitNumber;
        this.streetName = streetName;
        this.postalCode = postalCode;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    
    
    
    
}
