/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dobes Kuba
 */

//TODO findTEST...
public class UserDAOImplTest {
    private UserDAO userDao;
    
  
    @Before 
    public void SetUp(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SportActivityTestInMemory-PU");
        
        userDao = new UserDAOImpl();
        userDao.setEntityManagerFactory(emf);        

    }
    
    @After
    public void tearDown(){
    }
    
    @Test
    public void testCreateEmpty(){
       User user = new User();
       
        userDao.create(user);
        if (user.getId() == null){
            fail("Fail due to empty User");   
        }
    }
    
   
    @Test
    public void testCreateNullUser(){
       User user = null;
       try{ 
            userDao.create(user);
            fail("Create was called with null User");
       }catch(IllegalArgumentException ex){}
    }
    
    @Test
    public void testCreate(){
       User user = new User();
       
       user.setAge(12);
       user.setFirstName("Matin");
       user.setLastName("Hajanek");
      // user.setGender();
       user.setWeight(57);
       
       userDao.create(user);
       
       //ID can't be null
       assertNotNull(user.getId());
       Long userId = user.getId();
       
       User user2fromDB = userDao.get(userId);
       //are two objects equal?
       assertEquals(user, user2fromDB);
       //refer two object to the same object?
       assertSame(user, user2fromDB);
       
       assertEquals(user.getAge(), user2fromDB.getAge());
       assertEquals(user.getGender(), user2fromDB.getGender());
       assertEquals(user.getId(), user2fromDB.getId());
       assertEquals(user.getLastName(), user2fromDB.getLastName());
       assertEquals(user.getWeight(), user2fromDB.getWeight());
    }
    
    @Test
    public void testGet(){
        User user1 = new User();
        User user2 = new User();
        
        user1.setAge(21);
        user1.setFirstName("Brona");
        user1.setLastName("Kocu");
        user1.setWeight(120);
        //user1.setGender(null);
        
        user2.setAge(21);
        user2.setFirstName("Brona");
        user2.setLastName("Kocu");
        user2.setWeight(120);
        //user2.setGender(null);
        
        userDao.create(user1);
        userDao.create(user2);
        
        User getUserformDB = userDao.get(user1.getId());
        
        //id check  
        assertEquals(getUserformDB.getId(), user1.getId());
        if(getUserformDB.getId().equals(user2.getId()))fail("Two people with same atributes has same ID, but could not have.");
        assertNotSame(getUserformDB, user1);
        
        //prepras do 1 metody
        assertEquals(user1.getAge(), getUserformDB.getAge());
        assertEquals(user1.getGender(), getUserformDB.getGender());
        assertEquals(user1.getId(), getUserformDB.getId());
        assertEquals(user1.getLastName(), getUserformDB.getLastName());
        assertEquals(user1.getWeight(), getUserformDB.getWeight());
       
        try
        {
            userDao.get(null);
            fail("Plane id can not be Null");
        }catch(IllegalArgumentException ex){}
     
        
        //TODO findTEST...
    }
    
    
    
}   
