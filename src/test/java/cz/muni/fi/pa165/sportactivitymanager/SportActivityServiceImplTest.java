/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager;

import cz.muni.fi.pa165.sportactivitymanager.dao.SportActivityDAO;
import cz.muni.fi.pa165.sportactivitymanager.dao.impl.SportActivityDAOImpl;
import cz.muni.fi.pa165.sportactivitymanager.service.SportActivityService;
import cz.muni.fi.pa165.sportactivitymanager.dto.SportActivityDTO;
import cz.muni.fi.pa165.sportactivitymanager.service.impl.SportActivityServiceImpl;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 *
 * @author Petaniss
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:applicationContext.xml"})
public class SportActivityServiceImplTest {
    
    @Autowired
    private SportActivityServiceImpl sportService;
    
    @Test
    public void testCreateAndFind(){
       SportActivityDTO sportDto = new SportActivityDTO();
       
       sportDto.setName("diving");
       
       sportService.create(sportDto);
       
       
       //ID can't be null
       assertNotNull(sportDto.getId());
       
       
       Long sportId = sportDto.getId();
       
       SportActivityDTO sport2fromDB = sportService.getSportActivity(sportId);
       //are two objects equal?
       assertEquals(sportDto, sport2fromDB);
       //refer two object to the same object?
      // assertSame(userDto, user2fromDB);       
    }
    
}
