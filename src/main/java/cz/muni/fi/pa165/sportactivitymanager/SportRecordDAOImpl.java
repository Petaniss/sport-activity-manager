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

    EntityManagerFactory emf = null;
//    public SportRecordDAOImpl() {
//    }

    public SportRecordDAOImpl(EntityManagerFactory emf) {
//        this();
        if (emf == null) {
            throw new NullPointerException();
        }
        this.emf = emf;
    }

    public void create(SportRecord sportRecord) {
        if (sportRecord == null) {
            throw new NullPointerException();
        }
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(sportRecord);
        em.getTransaction().commit();
    }

    public SportRecord getSportRecord(Long id) {
        if (id == null) {
            throw new NullPointerException();
        }
        EntityManager em = emf.createEntityManager();
        return em.find(SportRecord.class, id);
    }
    
    public void delete(SportRecord sportRecord) {
        if (sportRecord == null)
            throw new NullPointerException(); 
        
        delete(sportRecord.getId());
    }
    
    public void delete(Long id) {
        if (id == null)
            throw new NullPointerException(); 
        
        EntityManager em = emf.createEntityManager();
        SportRecord srDel = em.find(SportRecord.class, id);
        
        if (srDel == null)
            throw new IllegalArgumentException("This entity does not exist in database.");
        
        em.getTransaction().begin();
        em.remove(srDel);
        em.getTransaction().commit();
    }
    

    public void update(SportRecord sportRecord) {
        if (sportRecord == null) {
            throw new NullPointerException();
        }
        EntityManager em = emf.createEntityManager();
        SportRecord srUpd = em.find(SportRecord.class, sportRecord.getId());
        if (srUpd == null) {
            throw new IllegalArgumentException("This entity does not exist in database.");
        }
    
        em.getTransaction().begin();
        em.persist(sportRecord);
        em.getTransaction().commit();
    }

    public List<SportRecord> findAll() {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("findAllSportRecord", SportRecord.class)
                .getResultList();
    }
//    public void setEntityManagerFactory(EntityManagerFactory emf) {
//        this.emf = emf;
//    }
}
