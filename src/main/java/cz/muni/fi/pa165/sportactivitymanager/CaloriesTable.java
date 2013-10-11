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

/**
 *
 * @author Petr Jelínek
 */
@Entity
public class CaloriesTable implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int calories130Lbs;
    private int calories155Lbs;
    private int calories180Lbs;
    private int calories205Lbs;

    public CaloriesTable() {
    }

    public CaloriesTable(int calories130Lbs, int calories155Lbs, int calories180Lbs, int calories205Lbs) {
        this.calories130Lbs = calories130Lbs;
        this.calories155Lbs = calories155Lbs;
        this.calories180Lbs = calories180Lbs;
        this.calories205Lbs = calories205Lbs;
    }

    public int getCalories130Lbs() {
        return calories130Lbs;
    }

    public void setCalories130Lbs(int calories130Lbs) {
        this.calories130Lbs = calories130Lbs;
    }

    public int getCalories155Lbs() {
        return calories155Lbs;
    }

    public void setCalories155Lbs(int calories155Lbs) {
        this.calories155Lbs = calories155Lbs;
    }

    public int getCalories180Lbs() {
        return calories180Lbs;
    }

    public void setCalories180Lbs(int calories180Lbs) {
        this.calories180Lbs = calories180Lbs;
    }

    public int getCalories205Lbs() {
        return calories205Lbs;
    }

    public void setCalories205Lbs(int calories205Lbs) {
        this.calories205Lbs = calories205Lbs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
