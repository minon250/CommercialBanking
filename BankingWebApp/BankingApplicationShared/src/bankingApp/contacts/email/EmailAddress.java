/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingApp.contacts.email;

import java.io.Serializable;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import org.apache.commons.lang3.*;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author minon
 */

@Embeddable
@Access(AccessType.PROPERTY)
public class EmailAddress implements Serializable {
    
    private String name;
    private String domain;

    public EmailAddress() {
    }

    public EmailAddress(String name, String domain) {
        this.name = name;
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public String toString() {
        return name + "@" + domain;
    }


    
    

    
    

   
    
    
    
    
    
    
    
    
}
