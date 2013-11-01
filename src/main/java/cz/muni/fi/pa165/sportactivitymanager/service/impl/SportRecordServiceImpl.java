/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager.service.impl;

import cz.muni.fi.pa165.sportactivitymanager.DataAccException;
import cz.muni.fi.pa165.sportactivitymanager.SportRecord;
import cz.muni.fi.pa165.sportactivitymanager.dto.SportRecordTO;
import cz.muni.fi.pa165.sportactivitymanager.dao.SportRecordDAO;
import cz.muni.fi.pa165.sportactivitymanager.dto.SportRecordTOChanger;
import cz.muni.fi.pa165.sportactivitymanager.service.SportRecordService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class SportRecordServiceImpl implements SportRecordService {

    private SportRecordDAO sRDao;

    public void setSRDao(SportRecordDAO sRDao) {
        this.sRDao = sRDao;
    }
    
    public void create(SportRecordTO sportRecordTO) {
        if (sportRecordTO != null) {
            try {
                SportRecord sr = SportRecordTOChanger.TOToEntity(sportRecordTO);
                sRDao.create(sr);
            } catch (DataAccessException ex) {
                throw new DataAccException(ex.toString());
            }
        } else {
            throw new NullPointerException("SportRecord can not be null.");
        }
    }

    public SportRecordTO getSportRecord(Long id) {
        SportRecordTO sportRecordTO = null;

        if (id != null) {
            try {
                SportRecord sportRecord = sRDao.getSportRecord(id);
                sportRecordTO = SportRecordTOChanger.entityToTO(sportRecord);
            } catch (DataAccessException ex) {
                throw new DataAccException(ex.toString());
            }
        } else {
            throw new NullPointerException("SportRecord ID is Null");
        }
        return sportRecordTO;

    }

    public void delete(SportRecordTO sportRecordTO) {
        if (sportRecordTO != null) {
            try {
                SportRecord sportRecord = SportRecordTOChanger.TOToEntity(sportRecordTO);
                sRDao.delete(sportRecord);
            } catch (DataAccessException ex) {
                throw new DataAccException(ex.toString());
            }
        } else {
            throw new NullPointerException("SportRecord can not be null.");
        }
    }

    public void delete(Long id) {
        if (id != null) {
            try {
                sRDao.delete(id);
            } catch (DataAccessException ex) {
                throw new DataAccException(ex.toString());
            }
        } else {
            throw new NullPointerException("SportRecord ID is Null");
        }
    }

    public void update(SportRecordTO sportRecordTO) {
        if (sportRecordTO != null) {
            try {
                SportRecord sportRecord = SportRecordTOChanger.TOToEntity(sportRecordTO);
                sRDao.update(sportRecord);
            } catch (DataAccessException ex) {
                throw new DataAccException(ex.toString());
            }
        } else {
            throw new NullPointerException("User can not be null.");
        }
    }

    public List<SportRecordTO> findAll() {
        List<SportRecordTO> sportRecordsTO = new ArrayList<SportRecordTO>();
        List<SportRecord> sportRecords;
        try {
            sportRecords = sRDao.findAll();
            sportRecordsTO = SportRecordTOChanger.entityListToDtoList(sportRecords);
        } catch (DataAccessException ex) {
            throw new DataAccException(ex.toString());
        }
        return sportRecordsTO;
    }
}