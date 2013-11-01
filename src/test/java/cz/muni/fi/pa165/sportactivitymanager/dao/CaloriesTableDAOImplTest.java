
package cz.muni.fi.pa165.sportactivitymanager.dao;

import cz.muni.fi.pa165.sportactivitymanager.CaloriesTable;
import cz.muni.fi.pa165.sportactivitymanager.Gender;
import cz.muni.fi.pa165.sportactivitymanager.dao.impl.CaloriesTableDAOImpl;
import cz.muni.fi.pa165.sportactivitymanager.dao.CaloriesTableDAO;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michal Galo
 */
public class CaloriesTableDAOImplTest
{
    private CaloriesTableDAO caloriesTableDAO;
    
    
    @Before
    public void SetUp()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SportActivityTestInMemory-PU");
        
        caloriesTableDAO = new CaloriesTableDAOImpl(emf);
    }    
        
    @Test(expected = NullPointerException.class)
    public void testCreateNull()
    {
        CaloriesTable ct = null;        
        caloriesTableDAO.create(ct);              
    }
    
    @Test
    public void testCreate()
    {
        CaloriesTable ct = new CaloriesTable();
        ct.setCalories60Kg(384);
        ct.setCalories70Kg(457);
        ct.setCalories80Kg(531);
        ct.setCalories90Kg(605);
        ct.setGender(Gender.MALE);        
        caloriesTableDAO.create(ct);
        
        assertNotNull(ct.getId());
        Long ctID = ct.getId();
        
        CaloriesTable ctDB = caloriesTableDAO.get(ctID);
        assertEquals(ct, ctDB);
        assertSame(ct, ctDB);
        
        assertEquals(ct.getId(), ctDB.getId());
        assertEquals(ct.getCalories60Kg(), ctDB.getCalories60Kg());
        assertEquals(ct.getCalories70Kg(), ctDB.getCalories70Kg());
        assertEquals(ct.getCalories80Kg(), ctDB.getCalories80Kg());
        assertEquals(ct.getCalories90Kg(), ctDB.getCalories90Kg());
        assertEquals(ct.getGender(), ctDB.getGender());       
    }
    
    @Test(expected = NullPointerException.class)
    public void testGetNull()
    {
        Long id = null;
        caloriesTableDAO.get(id);        
    }
    
    @Test
    public void testGet()
    {
        CaloriesTable ct1 = new CaloriesTable();
         ct1.setCalories60Kg(384);
         ct1.setCalories70Kg(457);
         ct1.setCalories80Kg(531);
         ct1.setCalories90Kg(605);
         ct1.setGender(Gender.MALE);
         caloriesTableDAO.create(ct1);
         
         CaloriesTable ct2 = new CaloriesTable();
         ct2.setCalories60Kg(413);
         ct2.setCalories70Kg(493);
         ct2.setCalories80Kg(572);
         ct2.setCalories90Kg(651);
         ct2.setGender(Gender.FEMALE);         
         caloriesTableDAO.create(ct2);
         
         Long id = ct1.getId();
         CaloriesTable ctDB = caloriesTableDAO.get(id);
         
         assertEquals(ctDB.getId(), ct1.getId());         
         assertSame(ct1, ctDB);
         assertNotSame(ct2, ctDB);
         
         assertEquals(ct1.getId(), ctDB.getId());
         assertEquals(ct1.getCalories60Kg(), ctDB.getCalories60Kg());
         assertEquals(ct1.getCalories70Kg(), ctDB.getCalories70Kg());
         assertEquals(ct1.getCalories80Kg(), ctDB.getCalories80Kg());
         assertEquals(ct1.getCalories90Kg(), ctDB.getCalories90Kg());
         assertEquals(ct1.getGender(), ctDB.getGender());       
    }    
    
    @Test(expected = NullPointerException.class)
    public void testUpdateNull()
    {
        caloriesTableDAO.update(null);        
    }
    
    @Test
    public void testUpdate()
    {
        
    }
    
    
    @Test(expected = NullPointerException.class)
    public void testDeleteIdNull()
    {
        Long id = null;
        caloriesTableDAO.delete(id);       
    }
    
    @Test
    public void testDeleteId()
    {
        CaloriesTable ct = new CaloriesTable();
        ct.setCalories60Kg(295);
        ct.setCalories70Kg(352);
        ct.setCalories80Kg(409);
        ct.setCalories90Kg(465);
        ct.setGender(Gender.MALE);
        caloriesTableDAO.create(ct);
        
    }
    
    @Test
    public void testDeleteNull()
    {
        
    }
    
    @Test
    public void testDelete()
    {
        
    }
    
    
    
    @Test
    public void testFindAll()
    {
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
