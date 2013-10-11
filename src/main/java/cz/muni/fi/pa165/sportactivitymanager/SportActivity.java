/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Petr Jelínek
 */
@Entity
@Table( name="Activity" )
@NamedQueries({
    @NamedQuery(name = "findByName", query = "SELECT s FROM SportActivity s where s.name = :name"),
    @NamedQuery(name = "findAll", query = "SELECT s FROM SportActivity s")
})
public class SportActivity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne
    private CaloriesTable calories;

    public SportActivity() {
    }

    public SportActivity(String name, CaloriesTable calories) {
        this.name = name;
        this.calories = calories;
    }

    public CaloriesTable getCalories() {
        return calories;
    }

    public void setCalories(CaloriesTable calories) {
        this.calories = calories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
}
