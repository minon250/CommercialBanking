/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingApp.repository;

import bankingApp.repository.entities.Transaction;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author minon
 */
@Remote
public interface TransactionsRepository {
    
    void makeTransaction(Transaction transaction);
    
    List<Transaction> getAllTransactions() throws Exception;
    
    List<Transaction> searchbyTransactionType(String type) throws Exception;
    
    Transaction serchByTransactionID(int id) throws Exception;
    
    List<Transaction> searchByTransactionName(String name) throws Exception;
    

    
 
    
    
    
    
    
            
    
}
