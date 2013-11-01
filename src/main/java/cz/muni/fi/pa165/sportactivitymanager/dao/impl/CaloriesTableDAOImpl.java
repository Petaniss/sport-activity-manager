
package cz.muni.fi.pa165.sportactivitymanager.dao.impl;

import cz.muni.fi.pa165.sportactivitymanager.CaloriesTable;
import cz.muni.fi.pa165.sportactivitymanager.dao.CaloriesTableDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Michal Galo
 */
public class CaloriesTableDAOImpl implements CaloriesTableDAO
{
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public CaloriesTableDAOImpl(EntityManagerFactory emf)
    {
        if (emf == null)
            throw new NullPointerException();
        
        this.emf = emf;
        this.em = emf.createEntityManager();        
    }    
    
    public void create(CaloriesTable caloriesTable)
    {
        if (caloriesTable == null)
            throw new NullPointerException();
        
        em.getTransaction().begin();
        em.persist(caloriesTable);
        em.getTransaction().commit();        
    }    
    
    public CaloriesTable get(Long id)
    {
        if (id == null)
            throw new NullPointerException();
        
        return em.find(CaloriesTable.class, id);        
    }  
    
    public void update(CaloriesTable caloriesTable)
    {
        if (caloriesTable == null)
            throw new NullPointerException();
        
        if (em.find(CaloriesTable.class, caloriesTable.getId()) == null)
            throw new IllegalArgumentException("This CaloriesTable entity does not exist in DB.");
        
        em.getTransaction().begin();
        em.persist(caloriesTable);
        em.getTransaction().commit();        
    }
    
    public void delete(Long id)
    {
        if (id == null)
            throw new NullPointerException();
        
        CaloriesTable toDelete = em.find(CaloriesTable.class, id);
        
        if (toDelete == null)
            throw new IllegalArgumentException("This CaloriesTable entity does not exist in DB.");
            
        em.getTransaction().begin();
        em.remove(toDelete);
        em.getTransaction().commit();
    }
    
    public void delete(CaloriesTable caloriesTable)
    {
        if (caloriesTable == null)
            throw new NullPointerException();
        
        this.delete(caloriesTable.getId());        
    }  
    
    public List<CaloriesTable> findAll()    
    {
        return em.createNativeQuery("findAll", CaloriesTable.class).getResultList();      
    }   
}
