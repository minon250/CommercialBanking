/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingApp.controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import bankingApp.repository.entities.*;
import bankingApp.repository.TransactionsRepository;
import javax.annotation.PostConstruct;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.StringUtils;
import bankingApp.other.TransactionType;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/*
 *
 * @author minon
 */
@Named(value = "transactionController")
@SessionScoped
public class TransactionController implements Serializable {

    @EJB
    private TransactionsRepository transactionsRepositoryImpl;

    private List<Transaction> transactionsList;

    private String searchString;

    private final String VIEW = "transactions";
    private Transaction selectedTransaction;
    private final String DETAIL_VIEW = "transactionDetails";

    public TransactionController() {

    }

    @PostConstruct
    public void init() {
        try {
            transactionsList = transactionsRepositoryImpl.getAllTransactions();
        } catch (Exception e) {
            System.out.println("Something went wrong " + e.getLocalizedMessage());

        }

    }

    public String getAll() throws Exception {
        // Used for the View All Button

        transactionsList = transactionsRepositoryImpl.getAllTransactions();
        return VIEW;

    }

    public List<Transaction> findAll() throws Exception {

        return this.transactionsList;
    }

    public void searchFilter() {
        /**
         * This function is a universal search filter If no search string is
         * present all records are presented If the search string is a number ,
         * executes the search by ID If the search string is String If DEPOSIT
         * or WITHDRAW executes search by type else executes search by name
         */
        searchString = searchString.toUpperCase();

        if (searchString.isEmpty()) {
            try {

                this.getAll();
                return;
            } catch (Exception e) {
                System.out.println("Cannot Display all records" + e.getLocalizedMessage());
            }
        }
        //Checking if the search string contains any symbols 
        if (!StringUtils.isAlphanumeric(searchString)) {
            RequestContext.getCurrentInstance().execute("swal('Invalid Characters Detected')");
            return;
        }

        if (isValidId(searchString)) {
            try {
                int id = Integer.parseInt(searchString);
                searchTransactionByID(id);
            } catch (Exception e) {
                System.out.println("ID " + e.getLocalizedMessage());
            }
        } else if (searchString.equals(TransactionType.DEPOSIT.name()) || searchString.equals(TransactionType.WITHDRAW.name())) {
            try {
                searchByTransactionType(searchString);
            } catch (Exception e) {
                System.out.println("Type " + e.getLocalizedMessage());
            }

        } else {
            try {
                searchByTransactionName(searchString);
            } catch (Exception e) {
                System.out.println("Name " + e.getLocalizedMessage());
            }

        }

    }

    public String transactionSelected(int id) {
        /**
         * Purpose is to respond to users click on a particular records Redirect
         * the user to a new the next page to display all details
         */
        try {
            selectedTransaction = transactionsRepositoryImpl.serchByTransactionID(id);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return DETAIL_VIEW;
    }

    private String searchTransactionByID(int searchId) {

        try {
            Transaction result = transactionsRepositoryImpl.serchByTransactionID(searchId);
            if (result != null) {
                transactionsList.clear();
                transactionsList.add(result);
            }
            else{
                RequestContext.getCurrentInstance().execute("swal('No Data to display')");
            }
            

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return VIEW;

    }

    private String searchByTransactionType(String searchType) {
        try {
            transactionsList = transactionsRepositoryImpl.searchbyTransactionType(searchType);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return VIEW;

    }

    private String searchByTransactionName(String searchName) {

        try {
            transactionsList = transactionsRepositoryImpl.searchByTransactionName(searchName);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return VIEW;
    }

    private boolean isValidId(String searchString) {
        /**
         * Return false if the search string is not a number OR ID < 0
         */
        if (!NumberUtils.isDigits(searchString)) {
            return false;
        } else {
            int id = Integer.parseInt(searchString);
            if (id < 0) {
                return false;
            }
        }
        //returns true when search string is a postive number
        return true;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public Transaction getSelectedTransaction() {
        return selectedTransaction;
    }

    public void setSelectedTransaction(Transaction selectedTransaction) {
        this.selectedTransaction = selectedTransaction;
    }

}
