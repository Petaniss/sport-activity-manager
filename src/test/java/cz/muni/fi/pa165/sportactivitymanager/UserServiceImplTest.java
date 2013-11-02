/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager;

import cz.muni.fi.pa165.sportactivitymanager.dao.UserDAO;
import cz.muni.fi.pa165.sportactivitymanager.dao.impl.UserDAOImpl;
import cz.muni.fi.pa165.sportactivitymanager.dto.UserDTO;
import cz.muni.fi.pa165.sportactivitymanager.dto.UserDTOChanger;

import cz.muni.fi.pa165.sportactivitymanager.service.impl.UserServiceImpl;
import cz.muni.fi.pa165.sportactivitymanager.mock.UserDAOMock;
import java.util.ArrayList;
import static org.mockito.Mockito.*;
import java.util.Date;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Dobes Kuba
 */


public class UserServiceImplTest {
    
    private UserServiceImpl uService;
  //  private UserDAOMock userMockDAO;
    private UserDAO userMockDAO;
    
    private UserDTO userDto;
    private User user;
    private User user2;
    //creates instance of userServiceImpl and sets it's DAO to MockDAO
    @Before
    public void setUp() {
        List<User> users = new ArrayList<User>();
     //   List<User> users = new ArrayList<>();
          
        uService = new UserServiceImpl();
      //  userMockDAO = new UserDAOMock();
        userMockDAO = mock(UserDAOImpl.class);
        uService.setUserDAO(userMockDAO);
        
       user = new User();       
       Date birthD3 = new Date(100, 10, 20);
       user.setBirthDay(birthD3);
       user.setFirstName("Matin");
       user.setLastName("Hajanek");
       user.setGender(Gender.MALE);
       user.setWeight(57);
       user.setId(Long.valueOf(11));
   
       user2 = new User();       
       Date birthD5 = new Date(100, 10, 20);
       user2.setBirthDay(birthD3);
       user2.setFirstName("Matin");
       user2.setLastName("Hajanek");
       user2.setGender(Gender.MALE);
       user2.setWeight(57);
       user2.setId(Long.valueOf(22));
       
//       userDto = new UserDTO();       
//       Date birthD4 = new Date(100, 10, 20);
//       userDto.setBirthDay(birthD4);
//       userDto.setFirstName("MatinDto");
//       userDto.setLastName("HajanekDto");
//       userDto.setGender(Gender.MALE);
//       userDto.setWeight(57);
//       
       users.add(user);
       users.add(user2);
       
       //reaction on call "userMockDAO.findAll())" in test is : .thenReturn(users);
       when(userMockDAO.findAll()).thenReturn(users);
       when(userMockDAO.getByID(Long.valueOf(22))).thenReturn(user2);
    }
    /*
     * Try create new user 
     * Then assertNotNull tests, whether id isn't null
     * Then assertSame/assertEquals tests, whether created object and object returned by Get method refer to the same object/are same.  
     * if not than throw Error
     * 
     */
    @Test
    public void testCreate(){
        
//        mService.addMachine(MachineDTOConverter.entityToDTO(machine2));
//        verify(mDAO).createMachine(machine2);
    
        uService.create(UserDTOChanger.entityToDTO(user));
        verify(userMockDAO).create(user);
    
        //NO MOCK TEST
//       UserDTO userDto = new UserDTO();
//       
//       Date birthD3 = new Date(100, 10, 20);
//       userDto.setBirthDay(birthD3);
//       userDto.setFirstName("Matin");
//       userDto.setLastName("Hajanek");
//       userDto.setGender(Gender.MALE);
//       userDto.setWeight(57);
//       
//       uService.create(userDto);
//       
//       //ID can't be null
//       assertNotNull(userDto.getId());
//       Long userId = userDto.getId();
//       
//       UserDTO user2fromDB = uService.getByID(userId);
//       //are two objects equal?
//       assertEquals(userDto, user2fromDB);
//       //refer two object to the same object?
//      // assertSame(user, user2fromDB);       
//       AssertUserCompletely(userDto,user2fromDB);
    }
    
     /*
     * Try create new Null user
     */
    @Test
    public void testCreateNullUser(){
        UserDTO userDto = null;
        
        try{ 
            uService.create(userDto);
            fail("Create was called with null UserDto");
       }catch(NullPointerException ex){}
    }
    
    /**
     * Test of Get method, of UserService class
     *
     * Create 2 new userDTOs.
     * Then assertEquals tests, whether created object and object returned by Get method are same and has same ID.  
     * Then conditional if tests, whether 2 users with same attributes has same ID, but could not have.
     * Then assertSame test whether 2 object are same.
     * AssertUserCompletely tests whether attributes of 2 objects are same. 
     * if not than throw Error
     * 
     * Than try get userDto1 with Null id, and negative id
     */    
    @Test
    public void testGet(){
        
        UserDTO userDto = uService.getByID(Long.valueOf(22));
        verify(userMockDAO).getByID(Long.valueOf(22));
        
        assertEquals(userDto.getId(), user2.getId());
        AssertUserCompletely(userDto,UserDTOChanger.entityToDTO(user2));
      
//       //PUVODNI TEST   
//        UserDTO userDto1 = new UserDTO();
//        UserDTO userDto2 = new UserDTO();
//        
//        Date birthD1 = new Date(90, 3, 20);
//        userDto1.setBirthDay(birthD1);
//        userDto1.setFirstName("Brona");
//        userDto1.setLastName("Kocu");
//        userDto1.setWeight(120);
//        userDto1.setGender(Gender.MALE);
//        
//        Date birthD2 = new Date(90, 3, 20);
//        userDto2.setBirthDay(birthD2);
//        userDto2.setFirstName("Brona");
//        userDto2.setLastName("Kocu");
//        userDto2.setWeight(120);
//        userDto2.setGender(Gender.MALE);
//        
//        uService.create(userDto1);
//        uService.create(userDto2);
//        
//        assertEquals(userDto1, uService.getByID(userDto1.getId()));
//        assertEquals(userDto2, uService.getByID(userDto2.getId()));
//        
//        UserDTO getUserformDB = uService.getByID(userDto1.getId());
//        //id check test 
//        assertEquals(getUserformDB.getId(), userDto1.getId());
//                
//        if(getUserformDB.getId().equals(userDto2.getId()))fail("Two different people with same atributes has same ID, but could not have.");
//     //   assertSame(getUserformDB, userDto1);
        
    }
    /**
     * Test of findAll method, of User class
     *
     * Create 3 new users.
     * Then tests findAll method, that should return all 3 object into List
     * Then assertTrue tests whether List contains all 3 users. 
     * Then assertEquals tests whether the list has right size
     * if not than throw Error
     */
    @Test
    public void testFindAll() {
        
        List<UserDTO> listUsersDto = new ArrayList<UserDTO>();
                
        listUsersDto = uService.findAll();
        verify(userMockDAO).findAll();
        
        assertEquals(2, listUsersDto.size());

        
//       //PUVODNI TEST 
//        long listSize = UserList.size();
//        assertEquals(3, listSize);
//        
//        UserDTO user1fromList = UserList.get(0);
//        AssertUserCompletely(userDto1,user1fromList);
//                
//        UserDTO user2fromList = UserList.get(1);
//        AssertUserCompletely(userDto2,user2fromList);
//        
//        UserDTO user3fromList = UserList.get(2);
//        AssertUserCompletely(userDto3,user3fromList);
//                
//        
//        System.out.println("test of findAll UsersDTO");
//        
//        UserDTO userDto1 = new UserDTO();
//        Date birthD = new Date(89, 20, 10);
//        userDto1.setBirthDay(birthD);
//        userDto1.setFirstName("Kuba");
//        userDto1.setGender(Gender.MALE);
//        userDto1.setLastName("Dobe");
//        
//        UserDTO userDto2 = new UserDTO();
//        Date birthD2 = new Date(89, 20, 10);
//        userDto2.setBirthDay(birthD2);
//        userDto2.setFirstName("Premysl Otakar");
//        userDto1.setGender(Gender.MALE);
//        userDto2.setLastName("Druhy");
//        
//        UserDTO userDto3 = new UserDTO();
//        Date birthD3 = new Date(89, 20, 10);
//        userDto3.setBirthDay(birthD3);
//        userDto3.setFirstName("Vaclav");
//        userDto1.setGender(Gender.MALE);
//        userDto3.setLastName("Treti");
//        
//        uService.create(userDto1);
//        uService.create(userDto2);
//        uService.create(userDto3);
//        
//        List<UserDTO> UserList = uService.findAll();
//        
//        assertTrue(UserList.contains(userDto1));
//        assertTrue(UserList.contains(userDto2));
//        assertTrue(UserList.contains(userDto3));
//        
//        long listSize = UserList.size();
//        assertEquals(3, listSize);
//        
//        UserDTO user1fromList = UserList.get(0);
//        AssertUserCompletely(userDto1,user1fromList);
//                
//        UserDTO user2fromList = UserList.get(1);
//        AssertUserCompletely(userDto2,user2fromList);
//        
//        UserDTO user3fromList = UserList.get(2);
//        AssertUserCompletely(userDto3,user3fromList);
     }
    
    /**
     * Test of Update method, that should update information about userDto1
     *  
     * Create new userDto1, then update his attributes 
     * Than assertEqual tests whether object and his attributes are same , 
     * if aren't than throw Error
     * 
     * Try update null userDto1
     */
    @Test
    public void testUpdate()
    {
        
     //   List<UserDTO> listUsersDto = new ArrayList<UserDTO>();
                
        uService.update(UserDTOChanger.entityToDTO(user));
        
        verify(userMockDAO).update(user);
        
        //PUVODNI TEST
//        UserDTO userDto1 = new UserDTO();
//        
//        Date birthD1 = new Date(90, 3, 20);
//        userDto1.setBirthDay(birthD1);
//        userDto1.setFirstName("Brona");
//        userDto1.setLastName("Stary");
//        userDto1.setWeight(120);
//        userDto1.setGender(Gender.MALE);
//        
//        uService.create(userDto1);
//        
//        Date birthD2 = new Date(89, 3, 20);
//        userDto1.setBirthDay(birthD2);
//        userDto1.setFirstName("Honza");
//        userDto1.setLastName("Novy");
//        userDto1.setWeight(82);
//        userDto1.setGender(Gender.MALE);
//        
//        uService.update(userDto1);
//        
//        assertNotNull(userDto1.getId());        
//        UserDTO userDTOFromDB = uService.getByID(userDto1.getId());
//        AssertUserCompletely(userDto1,userDTOFromDB);
//        
//        try{
//            uService.update(null);
//            fail("There is possible to update NULL userDTO");
//        }
//        catch(NullPointerException ex){}
   }
    
    /**
     * Test of Delete method, that should remove userDto1 
     * Try delete Null userDto1. 
     * Then create new regular userDto1. 
     * Then delete that userDto1 
     * and assertNull tests whether object is really Null, 
     * if isn't than throw Error
     */
    @Test
    public void TestDelete(){
        
        uService.delete(UserDTOChanger.entityToDTO(user));
        verify(userMockDAO).delete(user);
        
        //overit jestli je seznam mensi o smazanej objekt??
                
     //PUVODNI TEST   
//        try{
//            uService.delete(null);
//            fail("There is possible to delete NULL userDTO");
//        }catch(NullPointerException ex){}
//        
//        UserDTO userDto1 = new UserDTO();
//        
//        Date birthD1 = new Date(90, 3, 20);
//        userDto1.setBirthDay(birthD1);
//        userDto1.setFirstName("Brona");
//        userDto1.setLastName("Stary");
//        userDto1.setWeight(120);
//        userDto1.setGender(Gender.MALE);
//        
//        uService.create(userDto1);
//        //assertNotNull(uService.getByID(userDto1.getId()));
//        assertNotNull(userDto1.getId());
//        uService.delete(userDto1);
//        assertNull(uService.getByID(userDto1.getId()));
      }
    
    /**
     * Method for comparison information of 2 users that should be same
     * throw Error when aren't same
     */
    private void AssertUserCompletely(UserDTO userDto1, UserDTO userDto2) {
        assertEquals(userDto1.getBirthDay(),userDto2.getBirthDay());
        assertEquals(userDto1.getGender(), userDto2.getGender());
        assertEquals(userDto1.getId(), userDto2.getId());
        assertEquals(userDto1.getLastName(), userDto2.getLastName());
        assertEquals(userDto1.getWeight(), userDto2.getWeight());
    }
}
