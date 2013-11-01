/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager.service;

//aby fungoval import, bylo potřeba přidat Dependency na původní DAO třídy(SportActivityManager dependency)
import cz.muni.fi.pa165.sportactivitymanager.dto.UserDTO;
import java.util.List;

/**
 *
 * @author tempest
 */
public interface UserService {
/**
     * Creates new UserDto
     * 
     * @param userDto User that we store.
     * @throws IllegalArgumentException when argument is not instance of User class. 
     * @return nothing.
     */
    void create(UserDTO userDto);
    
    /**
     * Find existing UserDto
     * 
     * @param id is ID of User that we want getByID.
     * @throws IllegalArgumentException when ID is NULL. 
     * @return User with same id, or Null when user does not exist.
     */
    UserDTO getByID(Long id);
    
    /**
     * Delete existing UserDto
     * 
     * @param userDto is a userDto that we want to delete.
     * @throws IlleagalArgumentException when given userDto does not exist.
     * @throws NullPointerException when given userDto is not in DB.
     * @return nothing
     */
    void delete(UserDTO userDto);
    
    /**
     * Update existing UserDto
     * 
     * @param userDto is a userDto that we want to update.
     * @throws IlleagalArgumentException when given userDto does not exist.
     * @throws NullPointerException when given userDto is not in DB.
     * @return nothing
     */
    void update(UserDTO userDto);
    
    /**
     * Find all existing UserDTOs
     * 
     * @param nothing
     * @return List of all UserDTOs
     */
    List<UserDTO> findAll();
       
}
