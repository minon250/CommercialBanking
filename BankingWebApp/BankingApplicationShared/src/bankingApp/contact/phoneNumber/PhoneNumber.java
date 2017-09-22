/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingApp.contact.phoneNumber;

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
public class PhoneNumber implements Serializable {
    
    private int coutryCode;
    private int areaCode;
    private int phNumber;

    public PhoneNumber() {
    }
    
    

    public PhoneNumber(int coutryCode, int areaCode, int phNumber) {
        this.coutryCode = coutryCode;
        this.areaCode = areaCode;
        this.phNumber = phNumber;
    }

    public int getCoutryCode() {
        return coutryCode;
    }

    public void setCoutryCode(int coutryCode) {
        this.coutryCode = coutryCode;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public int getPhNumber() {
        return phNumber;
    }

    public void setPhNumber(int phNumber) {
        this.phNumber = phNumber;
    }
    
    

    
    
    
}
