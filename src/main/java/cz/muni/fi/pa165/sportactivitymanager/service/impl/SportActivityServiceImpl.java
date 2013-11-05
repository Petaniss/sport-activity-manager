/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager.service.impl;

import cz.muni.fi.pa165.sportactivitymanager.DataAccException;
import cz.muni.fi.pa165.sportactivitymanager.SportActivity;
import cz.muni.fi.pa165.sportactivitymanager.dao.SportActivityDAO;
import cz.muni.fi.pa165.sportactivitymanager.dto.SportActivityDTO;
import cz.muni.fi.pa165.sportactivitymanager.dto.SportActivityDTOChanger;
import cz.muni.fi.pa165.sportactivitymanager.service.SportActivityService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Petaniss
 */
@Service
public class SportActivityServiceImpl implements SportActivityService {
    
    private SportActivityDAO sportDAO;

    public SportActivityDAO getSportDAO() {
        return sportDAO;
    }

    public void setSportDAO(SportActivityDAO sportDAO) {
        this.sportDAO = sportDAO;
    }
    
    @Transactional
    public void create(SportActivityDTO sportActivityDTO) {
        if (sportActivityDTO != null)
        {
            try 
            {
                SportActivity activity = SportActivityDTOChanger.dtoToEntity(sportActivityDTO);
                sportDAO.create(activity);
                sportActivityDTO.setId(activity.getId());
            }
            catch(DataAccessException ex)
            {
                throw new DataAccException(ex.toString());
                                   
            }
        } else {
            throw new NullPointerException("SportActivity can not be null.");
        }
    }

    @Transactional
    public SportActivityDTO getSportActivity(Long id) {
        SportActivityDTO activityDto = null;
       
        if (id != null) 
        {
            try 
            {
                SportActivity activity = sportDAO.getSportActivity(id);
                activityDto = SportActivityDTOChanger.entityToDTO(activity);
            }
            catch(DataAccessException ex)
            {
                throw new DataAccException(ex.toString());
            }
        } else { 
            throw new NullPointerException("SportActivity ID is Null");
        }
        return activityDto;
    }

    @Transactional
    public SportActivityDTO getSportActivity(String name) {
        SportActivityDTO activityDto = null;
       
        if (name != null) 
        {
            try 
            {
                SportActivity activity = sportDAO.getSportActivity(name);
                activityDto = SportActivityDTOChanger.entityToDTO(activity);
            }
            catch(DataAccessException ex)
            {
                throw new DataAccException(ex.toString());
            }
        } else { 
            throw new NullPointerException("SportActivity name is Null");
        }
        return activityDto;
    }

    @Transactional
    public void delete(SportActivityDTO sportActivity) {
        if (sportActivity != null)
        {
            try {
                sportDAO.delete(sportActivity.getId());
            }
            catch(DataAccessException ex)
            {
                throw new DataAccException(ex.toString());
            }
        } else {
            throw new NullPointerException("SportActivity can not be null.");
        }
    }

    @Transactional
    public void update(SportActivityDTO sportActivity) {
        if (sportActivity != null)
        {
            try {
                SportActivity activity = SportActivityDTOChanger.dtoToEntity(sportActivity);
                sportDAO.update(activity);
            }
            catch(DataAccessException ex)
            {
                throw new DataAccException(ex.toString());
            }
        } else {
            throw new NullPointerException("SportActivity can not be null.");
        }
    }

    @Transactional
    public List<SportActivityDTO> findAll() {
        List<SportActivityDTO> activityDto = new ArrayList<SportActivityDTO>();
        
        try
        {
            List<SportActivity> activity = sportDAO.findAll();
            activityDto = SportActivityDTOChanger.entityListToDTOList(activity);
        }
        catch(DataAccessException ex)
        {
            throw new DataAccException(ex.toString());
        }
        
        return activityDto;
    }
    
}
