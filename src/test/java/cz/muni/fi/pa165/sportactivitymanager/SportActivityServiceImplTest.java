/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager;

import cz.muni.fi.pa165.sportactivitymanager.dao.SportActivityDAO;
import cz.muni.fi.pa165.sportactivitymanager.dto.SportActivityDTO;
import cz.muni.fi.pa165.sportactivitymanager.dto.SportActivityDTOChanger;
import cz.muni.fi.pa165.sportactivitymanager.service.SportActivityService;
import cz.muni.fi.pa165.sportactivitymanager.service.impl.SportActivityServiceImpl;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Petr Jelínek
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
    "classpath:applicationContext.xml"})
public class SportActivityServiceImplTest {
    
    @Autowired
    private SportActivityService sportService;
    
    private SportActivityServiceImpl mockService;
    private SportActivityDAO mockDAO;
    
    @Before
    public void setUp() {
        // service ve ktere se pouziva mock DAO misto zive implementace
        mockDAO = mock(SportActivityDAO.class);
        mockService = new SportActivityServiceImpl();
        mockService.setSportDAO(mockDAO);
    }
    
    @Test //test na implementaci(injekce z applicationContext.xml)
    public void testCreateAndFind() {

        SportActivityDTO sportDto = new SportActivityDTO();
        sportDto.setName("diving");

        sportService.create(sportDto);

        //ID can't be null
        assertNotNull(sportDto.getId());

        Long sportId = sportDto.getId();

        SportActivityDTO sport2fromDB = sportService.getSportActivity(sportDto.getName());
        assertEquals(sportDto, sport2fromDB);
    }
    
    @Test //mock DAO test
    public void testCreate() {
       SportActivityDTO sportDto = new SportActivityDTO();
       sportDto.setName("diving");
   
        mockService.create(sportDto);
        
        verify(mockDAO)
                .create(SportActivityDTOChanger.dtoToEntity(sportDto));
    }
    
    @Test
    public void testFindAll() {
        List<SportActivityDTO> listActivityDto = mockService.findAll();
        verify(mockDAO).findAll();
    }
    
    @Test
    public void testUpdate() {
        SportActivityDTO sportDto = new SportActivityDTO();
        sportDto.setName("diving");
        
        mockService.update(sportDto);
        verify(mockDAO)
                .update(SportActivityDTOChanger.dtoToEntity(sportDto));
    }
    
    @Test
    public void testGetByName() {
        mockService.getSportActivity("diving");
        verify(mockDAO)
                .getSportActivity("diving");
    }
    
    @Test
    public void testGetById() {
        mockService.getSportActivity(1L);
        verify(mockDAO)
                .getSportActivity(1L);
    }
    
}
