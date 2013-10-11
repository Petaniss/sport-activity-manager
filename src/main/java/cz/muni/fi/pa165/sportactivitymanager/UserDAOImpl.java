/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager;

import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Dobes Kuba
 * 
 */
class UserDAOImpl implements UserDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager em; 
    
    public UserDAOImpl(EntityManagerFactory emf) {
        if (emf == null) throw new NullPointerException();
        this.entityManagerFactory = emf;
        this.em = entityManagerFactory.createEntityManager();
    }

    public void create(User user) {
        if(user == null){
            throw new NullPointerException("User is Null");
        }
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public User getByID(Long id) {
        if(id == null){
            throw new NullPointerException("User ID is Null");
        }
        if(id < 0){
            throw new IllegalArgumentException("User ID must be Positive");
        }
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.getTransaction().commit();
        return user;
    }
    
    public void delete(User user) {
        if(user == null){
            throw new NullPointerException("User is Null");
        }
        em.getTransaction().begin();
        User user1 = em.find(User.class, user.getId());
        em.remove(user1);
        em.getTransaction().commit();
    }   

    public void update(User user) {
        if(user == null){
            throw new NullPointerException("User is Null");
        }
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public List<User> findAll() {
      
        List<User> list;
        
        em.getTransaction().begin();
        list = em.createQuery("SELECT u from User u").getResultList();
        em.getTransaction().commit();
        em.close();
        return Collections.unmodifiableList(list);
    }
    
}
