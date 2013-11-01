/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager;

import java.util.Date;

/**
 *
 * @author Phaser
 */
public class SportRecordTO {
     private Long id;

    private User user;
    //In seconds
    private Long duration;
    //in meters
    private int distance;
    private Date StartTime;

    public SportRecordTO(Long id, User user, Long duration, int distance, Date StartTime) {
        this.id = id;
        this.user = user;
        this.duration = duration;
        this.distance = distance;
        this.StartTime = StartTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date StartTime) {
        this.StartTime = StartTime;
    }
    
    
    
}
