/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager;

import cz.muni.fi.pa165.sportactivitymanager.dto.SportRecordTO;
import cz.muni.fi.pa165.sportactivitymanager.dto.UserDTO;
import cz.muni.fi.pa165.sportactivitymanager.service.SportRecordServiceImpl;
import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 *
 * @author Phaser
 */
public class SportRecordServiceImplTest {

    SportRecordServiceImpl srs = null;

    @Before
    public void setUp() {
        srs = new SportRecordServiceImpl();
    }

    /*
     * Try create new SportRecordTO 
     * Then assertNotNull tests, whether id isn't null
     * Then assertSame/assertEquals tests, whether created object and object returned by Get method refer to the same object/are same.  
     * if not than throw Error
     * 
     */
    @Test
    public void testCreate() {
        SportRecordTO mockedsportRecordTO = mock(SportRecordTO.class);
//        srs.create(mockedsportRecordTO);
//
//        srs.getSportRecord(mockedsportRecordTO.getId());
//
//        //ID can't be null
//        assertNotNull(mockedsportRecordTO.getId());
//
//
//        SportRecordTO sportRecordTO = srs.getSportRecord(mockedsportRecordTO.getId());
//        //are two objects equal?
//        assertEquals(mockedsportRecordTO, sportRecordTO);
//        //refer two object to the same object?
//        assertSame(mockedsportRecordTO, sportRecordTO);
    }
    
    
        @Test
    public void testGet(){
        UserDTO userDto1 = new UserDTO();
        UserDTO userDto2 = new UserDTO();
        
        Date birthD1 = new Date();
        userDto1.setBirthDay(birthD1);
        userDto1.setFirstName("Brona");
        userDto1.setLastName("Kocu");
        userDto1.setWeight(120);
        userDto1.setGender(Gender.MALE);
        
        Date birthD2 = new Date();
        userDto2.setBirthDay(birthD2);
        userDto2.setFirstName("Brona");
        userDto2.setLastName("Kocu");
        userDto2.setWeight(120);
        userDto2.setGender(Gender.MALE);
               
        SportRecordTO sportRecordTO1 = new SportRecordTO(Long.MIN_VALUE, userDto1, Long.MIN_VALUE, 100, new Date());
        SportRecordTO sportRecordTO2 = new SportRecordTO(Long.MIN_VALUE, userDto2, Long.MIN_VALUE, 100, new Date());
        
        
        
        srs.create(sportRecordTO1);
        srs.create(sportRecordTO2);
        
        assertEquals(sportRecordTO1, srs.getSportRecord(sportRecordTO1.getId()));
        assertEquals(sportRecordTO2, srs.getSportRecord(sportRecordTO2.getId()));
        
        SportRecordTO sportRecordDB = srs.getSportRecord(sportRecordTO1.getId());
        //id check test 
        assertEquals(sportRecordDB.getId(), sportRecordTO1.getId());
        if(sportRecordDB.getId().equals(sportRecordTO2.getId()))fail("Two different SportRecord with same atributes has same ID, but could not have.");   
              
        try{
            srs.getSportRecord(null);
            fail("SportRecord id can not be Null");
        }
        catch(NullPointerException ex){}
        
        try{
            srs.getSportRecord(Long.valueOf("-1"));
            fail("ID was set to negative number");
        }
        catch(IllegalArgumentException ex){}
     }
    
}
