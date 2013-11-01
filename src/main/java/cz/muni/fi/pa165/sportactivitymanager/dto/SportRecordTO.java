/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager.dto;

import cz.muni.fi.pa165.sportactivitymanager.dto.UserDTO;
import java.util.Date;

/**
 *
 * @author Phaser
 */
public class SportRecordTO {
    private Long id;
    private UserDTO user;
    //In seconds
    private Long duration;
    //in meters
    private int distance;
    private Date StartTime;

    public SportRecordTO() {
    }
    
    public SportRecordTO(Long id, UserDTO user, Long duration, int distance, Date StartTime) {
        this();
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

    public UserDTO getUserDTO() {
        return user;
    }

    public void setUserDTO(UserDTO user) {
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
