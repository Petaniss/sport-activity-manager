package cz.muni.fi.pa165.sportactivitymanager;

import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("Sport");
         SportRecordDAOImpl srDAO = new SportRecordDAOImpl(emf);
         SportRecord sr = new SportRecord();
         sr.setDistance(10);
         sr.setDuration(Long.MIN_VALUE);
         sr.setStartTime(new Date());
         srDAO.create(sr);
    }
}
