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
import javax.persistence.Table;

/**
 *
 * @author Dobes Kuba
 */
@Entity
@Table( name="Athlete" )
public class User implements Serializable{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String firstName;
   private String lastName;
   private Integer age; 
   private Integer weight;
   private Gender gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (object == null) {
            return false;
        }
        if (getClass() != object.getClass()) {
            return false;
        }
        User other = (User) object;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "cz.muni.fi.pa165.sportactivitymanager.User[ id=" + id + " ]";
    }
    
}
