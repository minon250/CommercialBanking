/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingApp.repository.entities;

import bankingApp.contact.phoneNumber.PhoneNumber;
import bankingApp.contacts.Address.Address;
import bankingApp.contacts.email.EmailAddress;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author minon
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USER_TYPE",discriminatorType = DiscriminatorType.STRING, length = 1)
@NamedQueries({@NamedQuery(name = SystemUser.GET_ALL_QUERY_NAME, query ="SELECT u from SystemUser u")})
public class SystemUser implements Serializable{
    
    public static final String GET_ALL_QUERY_NAME = "SystemUser.getAll";
    
    //This is a unique ID generated automatically
    private int userID;
    private String lastName;
    private String firstName;
    
    //Contacts
    private EmailAddress emailAddress;
    private Address address;
    private PhoneNumber phoneNumber;
    
    

    
    //A user can have many types of tranasactions 
    public Set<Transaction> transactions;

    public SystemUser() {
    }

    public SystemUser(int userID, String lastName, String firstName, EmailAddress emailAddress, Address address, PhoneNumber phoneNumber) {
        this.userID = userID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    



    @Id
    @GeneratedValue
    @Column(name = "user_ID")
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Embedded
    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(EmailAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    @Embedded
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "SystemUser{" + "userID=" + userID + ", lastName=" + lastName + ", firstName=" + firstName + ", emailAddress=" + emailAddress + ", address=" + address + ", phoneNumber=" + phoneNumber + '}';
    }

    
    @OneToMany(mappedBy = "bankUser")
    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }


    
    
    
    
    
    
    

    
}
