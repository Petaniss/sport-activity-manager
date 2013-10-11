/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Adam Brauner
 */
public class SportActivityDAOImplTest {
    
    private SportActivityDAO sportActivityDao;
    
    @Before
    public void SetUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sport");
        sportActivityDao = new SportActivityDAOImpl(emf);
    }

    @After
    public void tearDown() {
        
    }

    @Test
    public void testCreateEmpty() {
        SportActivity sa = new SportActivity();
        sa.setName("Archery");
        
        sportActivityDao.create(sa);

        if (sa.getId() == null) {
            fail("Fail during SportActivity create");
        }
    }
    
    @Test
    public void testCreateNullActivity() {
        try {
            sportActivityDao.create(null);
            fail("Create was called with null Activity");
        } catch (NullPointerException ex) {
        }
    }
    
    @Test
    public void testDeleteNullOrNonExistActivity() {
        SportActivity sa = null;
        try {
            sportActivityDao.delete(sa);
            fail("Create was called with null Activity");
        } catch (NullPointerException ex) {
        }
        
        SportActivity sa2 = new SportActivity();
        sa2.setName("Archery");
        sa2.setId(Long.MIN_VALUE);
        try {
            sportActivityDao.delete(sa2);
            fail("Delete Activity is not exist in db");
        } catch (IllegalArgumentException ex) {
        }
    }
    
    @Test
    public void testCreateAndGet() {
        SportActivity sa = new SportActivity();
        sa.setName("Archery");

        sportActivityDao.create(sa);

        //ID can't be null
        assertNotNull(sa.getId());
        Long saId = sa.getId();

        SportActivity sa2fromDB = sportActivityDao.getSportActivity(saId);
        //are two objects equal?
        assertEquals(sa, sa2fromDB);
        //refer two object to the same object?
        assertSame(sa, sa2fromDB);

        assertEquals(sa.getId(), sa2fromDB.getId());
        assertEquals(sa.getName(), sa2fromDB.getName());
    }
    
    @Test
    public void testFindAll() {
        SportActivity sa = new SportActivity();
        sa.setName("Archery");
        SportActivity sa2 = new SportActivity();
        sa2.setName("Diving");

        sportActivityDao.create(sa);
        sportActivityDao.create(sa2);
        List<SportActivity> all = sportActivityDao.findAll();
        
        if (all.size() != 2)
            fail("findAll dont return all activities");
    }
      
    




        //TODO findTEST...
    
}
