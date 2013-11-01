/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager.dto;

import cz.muni.fi.pa165.sportactivitymanager.SportRecord;
import cz.muni.fi.pa165.sportactivitymanager.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phaser
 */
public class SportRecordTOChanger {
    
    //convert SportRecordTO to Entity SportRecord
    public static SportRecord TOToEntity(SportRecordTO sportRecordTO) {
        
        if(null == sportRecordTO) return null;
        
        SportRecord sportRecord = new SportRecord();  
        
        sportRecord.setId(sportRecordTO.getId());
        sportRecord.setDistance(sportRecordTO.getDistance());
        sportRecord.setDuration(sportRecordTO.getDuration());
        sportRecord.setStartTime(sportRecordTO.getStartTime());        
        sportRecord.setUser(UserDTOChanger.dtoToUserEntity(sportRecordTO.getUserDTO()));
        return sportRecord;
    }
    
        //convert SportRecord to Entity SportRecordTO
    public static SportRecordTO entityToTO(SportRecord sportRecord) {
        
        if(null == sportRecord) return null;
        
        SportRecordTO sportRecordTO = new SportRecordTO();  
        
        sportRecordTO.setId(sportRecord.getId());
        sportRecordTO.setDistance(sportRecord.getDistance());
        sportRecordTO.setDuration(sportRecord.getDuration());
        sportRecordTO.setStartTime(sportRecord.getStartTime());        
        sportRecordTO.setUserDTO(UserDTOChanger.entityToDTO(sportRecord.getUser()));
        return sportRecordTO;
    }
    
    public static List<SportRecordTO> entityListToDtoList( List<SportRecord> sportRecord ) {
        if(sportRecord == null) return null;
        
        List<SportRecordTO> sportRecordTOList =  new ArrayList<SportRecordTO>();
        for(int i = 0; i<sportRecord.size(); i++){
            sportRecordTOList.add(entityToTO(sportRecord.get(i)));
        }
        return sportRecordTOList;
    }
    
    
    
}
