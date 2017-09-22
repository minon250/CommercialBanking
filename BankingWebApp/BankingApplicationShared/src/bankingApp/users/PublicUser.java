/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingApp.users;

import bankingApp.contact.phoneNumber.PhoneNumber;
import bankingApp.contacts.Address.Address;
import bankingApp.contacts.email.EmailAddress;
import bankingApp.repository.entities.SystemUser;
import bankingApp.repository.entities.Transaction;
import java.util.Set;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author minon
 */
@Entity(name = "Public_Users")
@DiscriminatorValue(value = "P")
public class PublicUser extends SystemUser{

    public PublicUser(int userID, String lastName, String firstName, EmailAddress emailAddress, Address address, PhoneNumber phoneNumber) {
        super(userID, lastName, firstName, emailAddress, address, phoneNumber);
    }
    





    
    
    
    
    
    

    public PublicUser() {
    }
    
    
    
    
}
