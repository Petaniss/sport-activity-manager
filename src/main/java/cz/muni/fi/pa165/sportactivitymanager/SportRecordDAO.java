/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager;

import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Phaser
 */
public interface SportRecordDAO {
     /**
     * Creates new User
     * 
     * @param sportRecord SportRecord that we store.
     * @throws IllegalArgumentException when argument is not instance of SportRecord class. 
     * @return nothing.
     */
    void create(SportRecord sportRecord);
    
    /**
     * Find existing User
     * 
     * @param id is ID of SportRecord that we want get.
     * @throws IllegalArgumentException when ID is NULL. 
     * @return SportRecord with same id, or Null when SportRecord does not exist.
     */
    User getSportRecord(Long id);
    
    /**
     * Delete existing SportRecord
     * 
     * @param sportRecord is a sportRecord that we want to delete.
     * @throws IlleagalArgumentException when given sportRecord does not exist.
     * @throws NullPointerException when given sportRecord is not in DB.
     * @return nothing
     */
    void delete(SportRecord sportRecord);
    
    /**
     * Update existing sportRecord
     * 
     * @param sportRecord is a sportRecord that we want to update.
     * @throws IlleagalArgumentException when given sportRecord does not exist.
     * @throws NullPointerException when given sportRecord is not in DB.
     * @return nothing
     */
    void update(SportRecord sportRecord);
    
    /**
     * Find all existing SportRecord
     * 
     * @param nothing
     * @return List of all SportRecord
     */
    List<User> findAll();
    
    
    /**
     * Sets EntityManagerFactory for using in this class
     * 
     * @param emf is instance of EntityManagerFactory
     * @return nothing
     */
    void setEntityManagerFactory(EntityManagerFactory emf);
}
