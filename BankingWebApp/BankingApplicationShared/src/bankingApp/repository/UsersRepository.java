/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingApp.repository;

import bankingApp.repository.entities.SystemUser;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author minon
 */
@Remote
public interface UsersRepository {
    
    List<SystemUser> getAllSystemUsers();
    
    List<SystemUser> searchByName(String name);
    
    SystemUser searchByID(int id);
    
    void addUser(SystemUser user);
    
    void updateUser(SystemUser user);
    
    void deleteUser(int id);
    
}
