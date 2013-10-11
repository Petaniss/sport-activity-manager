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
 * @author Petr Jelínek
 */
public class SportActivityDAOImpl implements SportActivityDAO {
    
    private EntityManagerFactory emf;
    private EntityManager em;

    public SportActivityDAOImpl(EntityManagerFactory emf) {
        if (emf == null) throw new NullPointerException();
        this.emf = emf;
        this.em = emf.createEntityManager();
    }
    
    public void create(SportActivity sportActivity) {
        if (sportActivity == null)
            throw new NullPointerException();
        
        em.getTransaction().begin();
        em.persist(sportActivity);
        em.getTransaction().commit();
    }

    public SportActivity getSportActivity(Long id) {
        if (id == null)
            throw new NullPointerException();
        
        return em.find(SportActivity.class, id);
    }

    public SportActivity getSportActivity(String name) {
        if (name == null)
            throw new NullPointerException();
        if (name.length() == 0)
            throw new IllegalArgumentException();
        
        return em.createNamedQuery("findByName", SportActivity.class)
            .setParameter("name", name)
            .getSingleResult();
    }

    public void delete(SportActivity sportActivity) {
        if (sportActivity == null)
            throw new NullPointerException(); 
        
        this.delete(sportActivity.getId());
    }
    
    public void delete(Long id) {
        if (id == null)
            throw new NullPointerException(); 
        
        SportActivity toDelete = em.find(SportActivity.class, id);
        
        if (toDelete == null)
            throw new IllegalArgumentException("this entity does not exist in database.");
        
        em.getTransaction().begin();
        em.remove(toDelete);
        em.getTransaction().commit();
    }

    public void update(SportActivity sportActivity) {
        if (sportActivity == null)
            throw new NullPointerException();
        
        if (em.find(SportActivity.class, sportActivity.getId()) == null)
            throw new IllegalArgumentException("this entity does not exist in database");
        
        em.getTransaction().begin();
        em.persist(sportActivity);
        em.getTransaction().commit();
    }

    public List<SportActivity> findAll() {
        return em.createNamedQuery("findAll", SportActivity.class)
            .getResultList();
        
    }   


}
