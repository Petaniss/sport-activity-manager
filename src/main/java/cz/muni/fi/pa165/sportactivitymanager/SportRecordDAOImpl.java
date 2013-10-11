/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Adam Brauner
 */
public class SportRecordDAOImpl implements SportRecordDAO {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;
//    public SportRecordDAOImpl() {
//    }

    public SportRecordDAOImpl(EntityManagerFactory emf) {
//        this();
        if (emf == null) {
            throw new NullPointerException();
        }
        this.emf = emf;
        em = emf.createEntityManager();
    }

    public void create(SportRecord sportRecord) {
        if (sportRecord == null) {
            throw new NullPointerException();
        }
        em.getTransaction().begin();
        em.persist(sportRecord);
        em.getTransaction().commit();
    }

    public SportRecord getSportRecord(Long id) {
        if (id == null) {
            throw new NullPointerException();
        }
        return em.find(SportRecord.class, id);
    }
    
    public void delete(SportRecord sportRecord) {
        if (sportRecord == null)
            throw new NullPointerException(); 
        
        this.delete(sportRecord.getId());
    }
    
        public void delete(Long id) {
        if (id == null)
            throw new NullPointerException(); 
        
        SportRecord toDelete = em.find(SportRecord.class, id);
        
        if (toDelete == null)
            throw new IllegalArgumentException("this entity does not exist in database.");
        
        em.getTransaction().begin();
        em.remove(toDelete);
        em.getTransaction().commit();
    }
    
    

    public void update(SportRecord sportRecord) {
        if (sportRecord == null) {
            throw new NullPointerException();
        }
        SportRecord srUpd = em.find(SportRecord.class, sportRecord.getId());
        if (srUpd == null) {
            throw new IllegalArgumentException("This entity does not exist in database.");
        }    
        em.getTransaction().begin();
        em.persist(sportRecord);
        em.getTransaction().commit();
    }

    public List<SportRecord> findAll() {
        return em.createNamedQuery("findAllSportRecord", SportRecord.class)
                .getResultList();
    }
//    public void setEntityManagerFactory(EntityManagerFactory emf) {
//        this.emf = emf;
//    }
}
