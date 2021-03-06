
package cz.muni.fi.pa165.sportactivitymanager.dao.impl;

import cz.muni.fi.pa165.sportactivitymanager.CaloriesTable;
import cz.muni.fi.pa165.sportactivitymanager.dao.CaloriesTableDAO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Michal Galo
 */
public class CaloriesTableDAOImpl implements CaloriesTableDAO
{    
    private EntityManager em;
    
    public CaloriesTableDAOImpl(){}
    
    public CaloriesTableDAOImpl(EntityManager em)
    {
        if (em == null) throw new NullPointerException();
        
        this.em = em;        
    }    
    
    public EntityManager getEm()        { return em; }
    public void setEm(EntityManager em) { this.em = em; }    
    
    public void create(CaloriesTable caloriesTable)
    {
        if (caloriesTable == null) throw new NullPointerException();
                
        em.persist(caloriesTable);                
    }    
    
    public CaloriesTable get(Long id)
    {
        if (id == null) throw new NullPointerException();
        
        return em.find(CaloriesTable.class, id);        
    }  
    
    public void update(CaloriesTable caloriesTable)
    {
        if (caloriesTable == null) throw new NullPointerException();
        
        if (em.find(CaloriesTable.class, caloriesTable.getId()) == null)
            throw new IllegalArgumentException("This CaloriesTable entity does not exist in DB.");
               
        em.persist(caloriesTable);               
    }
    
    public void delete(Long id)
    {
        if (id == null)  throw new NullPointerException();
        
        CaloriesTable toDelete = em.find(CaloriesTable.class, id);
        
        if (toDelete == null) throw new IllegalArgumentException("This CaloriesTable entity does not exist in DB.");
               
        em.remove(toDelete);        
    }
    
    public void delete(CaloriesTable caloriesTable)
    {
        if (caloriesTable == null) throw new NullPointerException();
        
        this.delete(caloriesTable.getId());        
    }  
    
    public List<CaloriesTable> findAll()    
    {
        return em.createNamedQuery("findAllCaloriesTables", CaloriesTable.class).getResultList();      
    }   
}
