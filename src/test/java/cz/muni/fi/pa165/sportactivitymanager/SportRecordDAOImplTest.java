/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager;

import java.util.Date;
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
 * @author Petr Jelínek
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
            fail("Fail due to empty Record");
        }
    }

    @Test
    public void testCreateNullSportRecord() {
        try {
            sportRecordDAO.create(null);
            fail("Create was called with null Record");
        } catch (NullPointerException ex) {
        }
    }

    @Test
    public void testDeleteNullRecord() {
        SportRecord sr1 = null;
        try {
            sportRecordDAO.delete(sr1);
            fail("Create was called with null Record");
        } catch (NullPointerException ex) {
        }
    }

    @Test
    public void testDeleteNonExistRecord() {
        SportRecord sr2 = new SportRecord();
        sr2.setId(Long.MIN_VALUE);
        sr2.setDistance(10);
        sr2.setDuration(Long.MIN_VALUE);
        sr2.setStartTime(new Date());
        try {
            sportRecordDAO.delete(sr2);
            fail("Delete Activity is not exist in db");
        } catch (IllegalArgumentException ex) {
        }
    }

    @Test
    public void testCreateAndGet() {
        SportRecord sr = new SportRecord();
        sr.setDistance(10);
        sr.setDuration(Long.MIN_VALUE);
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
        assertEquals(sr.getDistance(), sr2fromDB.getDistance());
        assertEquals(sr.getDuration(), sr2fromDB.getDuration());
        assertEquals(sr.getStartTime(), sr2fromDB.getStartTime());
    }

    @Test
    public void testFindAll() {
        SportRecord sr1 = new SportRecord();
        SportRecord sr2 = new SportRecord();
        sportRecordDAO.create(sr1);
        sportRecordDAO.create(sr2);
        List<SportRecord> all = sportRecordDAO.findAll();

        if (all.size() != 2) {
            fail("findAll dont return all activities");
        }
    }
}
