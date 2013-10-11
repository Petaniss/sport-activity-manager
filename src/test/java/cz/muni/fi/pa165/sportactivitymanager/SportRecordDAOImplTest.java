/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager;

import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Adam Brauner
 */
public class SportRecordDAOImplTest {

    private SportRecordDAO sportRecordDAO;

    @Before
    public void SetUp() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SportActivityTestInMemory-PU");

        sportRecordDAO = new SportRecordDAOImpl(emf);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateEmpty() {
        SportRecord sr = new SportRecord();

        sportRecordDAO.create(sr);
        if (sr.getId() == null) {
            fail("Fail due to empty User");
        }
    }

    @Test
    public void testCreateNullUser() {
        SportRecord sr = null;
        try {
            sportRecordDAO.create(sr);
            fail("Create was called with null User");
        } catch (IllegalArgumentException ex) {
        }
    }

    @Test
    public void testCreate() {
        SportRecord sr = new SportRecord();
        User u = new User();
        sr.setUser(u);
        sr.setDuration(12L);
        sr.setDistance(12);
        sr.setStartTime(new Date());

        sportRecordDAO.create(sr);

        //ID can't be null
        assertNotNull(sr.getId());
        Long srId = sr.getId();

        SportRecord sr2fromDB = sportRecordDAO.getSportRecord(srId);
        //are two objects equal?
        assertEquals(sr, sr2fromDB);
        //refer two object to the same object?
        assertSame(sr, sr2fromDB);

        assertEquals(sr.getId(), sr2fromDB.getId());
        assertEquals(sr.getUser(), sr2fromDB.getUser());
        assertEquals(sr.getDuration(), sr2fromDB.getDuration());
        assertEquals(sr.getDistance(), sr2fromDB.getDistance());
        assertEquals(sr.getStartTime(), sr2fromDB.getStartTime());
    }

    @Test
    public void testGet() {
        User user1 = new User();
        User user2 = new User();

        SportRecord sr1 = new SportRecord();
        User u1 = new User();
        sr1.setUser(u1);
        sr1.setDuration(12L);
        sr1.setDistance(12);
        sr1.setStartTime(new Date());

        SportRecord sr2 = new SportRecord();
        User u2 = new User();
        sr2.setUser(u2);
        sr2.setDuration(12L);
        sr2.setDistance(12);
        sr2.setStartTime(new Date());

        sportRecordDAO.create(sr1);
        sportRecordDAO.create(sr2);

        SportRecord getSportRecordformDB = sportRecordDAO.getSportRecord(sr1.getId());

        //id check  
        assertEquals(getSportRecordformDB.getId(), sr1.getId());
        if (getSportRecordformDB.getId().equals(sr2.getId())) {
            fail("Two people with same atributes has same ID, but could not have.");
        }
        assertNotSame(getSportRecordformDB, sr1);

        assertEquals(sr1.getId(), getSportRecordformDB.getId());
        assertEquals(sr1.getUser(), getSportRecordformDB.getUser());
        assertEquals(sr1.getDuration(), getSportRecordformDB.getDuration());
        assertEquals(sr1.getDistance(), getSportRecordformDB.getDistance());
        assertEquals(sr1.getStartTime(), getSportRecordformDB.getStartTime());

        try {
            sportRecordDAO.getSportRecord(null);
            fail("Plane id can not be Null");
        } catch (IllegalArgumentException ex) {
        }


        //TODO findTEST...
    }
}
