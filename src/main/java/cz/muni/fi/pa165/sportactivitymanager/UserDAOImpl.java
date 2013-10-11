/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager;

import cz.muni.fi.pa165.sportactivitymanager.User;
import cz.muni.fi.pa165.sportactivitymanager.UserDAO;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author tempest
 * TODD
 * JEN PRO FUNKCNOST ostatnich trid, ale implementace neni nakodena
 */
class UserDAOImpl implements UserDAO {

    public UserDAOImpl() {
    }

    public void create(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User get(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void update(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEntityManagerFactory(EntityManagerFactory emf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
