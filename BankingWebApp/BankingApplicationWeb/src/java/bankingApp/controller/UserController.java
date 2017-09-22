/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingApp.controller;

import bankingApp.contact.phoneNumber.PhoneNumber;
import bankingApp.contacts.Address.Address;
import bankingApp.contacts.email.EmailAddress;
import bankingApp.repository.UsersRepository;
import bankingApp.repository.entities.SystemUser;
import bankingApp.users.BankUser;
import bankingApp.users.PublicUser;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.swing.text.html.parser.DTDConstants;
import org.primefaces.context.*;

/**
 *
 * @author minon
 */
@Named(value = "userController")
@SessionScoped
public class UserController implements Serializable {

    @EJB
    private UsersRepository usersRepositoryImpl;

    private List<SystemUser> systemUsers;

    private String firstName, lastName, streetName, unitNumber, domain, name;
    private int postalCode, areaCode, countryCode, phoneNumber;

    private final String VIEW = "users";

    public UserController() {
    }

    @PostConstruct
    public void init() {
        try {
            systemUsers = usersRepositoryImpl.getAllSystemUsers();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

    }

    public List<SystemUser> findAll() throws Exception {
        return this.systemUsers;
    }

    public void addBankUser() {
        try {
            BankUser bankUser = new BankUser();
            bankUser.setFirstName(firstName.toUpperCase());
            bankUser.setLastName(lastName.toUpperCase());
            bankUser.setAddress(new Address(unitNumber, streetName, postalCode));
            bankUser.setEmailAddress(new EmailAddress(name.toUpperCase(), domain.toUpperCase()));
            bankUser.setPhoneNumber(new PhoneNumber(countryCode, areaCode, phoneNumber));

            usersRepositoryImpl.addUser(bankUser);
            RequestContext.getCurrentInstance().execute("swal(\"Record Added!\", \"You clicked the button!\", \"success\")");

        } catch (Exception e) {
            RequestContext.getCurrentInstance().execute("swal('Invalid Characters Detected')");
            System.out.println("Error adding record" + e.getLocalizedMessage());
        }

    }

    public void addPublicUser() {
        try {
            PublicUser publicUser = new PublicUser();
            publicUser.setFirstName(firstName.toUpperCase());
            publicUser.setLastName(lastName.toUpperCase());
            publicUser.setAddress(new Address(unitNumber, streetName, postalCode));
            publicUser.setEmailAddress(new EmailAddress(name.toUpperCase(), domain.toUpperCase()));
            publicUser.setPhoneNumber(new PhoneNumber(countryCode, areaCode, phoneNumber));

            usersRepositoryImpl.addUser(publicUser);
            RequestContext.getCurrentInstance().execute("swal(\"Record Added!\", \"You clicked the button!\", \"success\")");

        } catch (Exception e) {
            RequestContext.getCurrentInstance().execute("swal('Invalid Characters Detected')");
            System.out.println("Error adding record" + e.getLocalizedMessage());
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

}
