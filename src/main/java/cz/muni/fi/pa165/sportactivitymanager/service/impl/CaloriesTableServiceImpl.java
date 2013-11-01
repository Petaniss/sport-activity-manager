
package cz.muni.fi.pa165.sportactivitymanager.service.impl;

import cz.muni.fi.pa165.sportactivitymanager.CaloriesTable;
import cz.muni.fi.pa165.sportactivitymanager.dao.CaloriesTableDAO;
import cz.muni.fi.pa165.sportactivitymanager.dto.CaloriesTableDTO;
import cz.muni.fi.pa165.sportactivitymanager.dto.CaloriesTableDTOChanger;
import cz.muni.fi.pa165.sportactivitymanager.service.CaloriesTableService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michal Galo
 */
public class CaloriesTableServiceImpl implements CaloriesTableService
{
    private CaloriesTableDAO caloriesTableDAO;
    
    public CaloriesTableDAO getDAO()                      { return caloriesTableDAO; }    
    public void setDAO(CaloriesTableDAO caloriesTableDAO) { this.caloriesTableDAO = caloriesTableDAO; }
       
    public void create(CaloriesTableDTO caloriesTableDTO)
    {
        CaloriesTable caloriesTable = CaloriesTableDTOChanger.dtoToEntity(caloriesTableDTO);
        caloriesTableDAO.create(caloriesTable);
        caloriesTableDTO.setId(caloriesTable.getId());        
    }    
    
    public CaloriesTableDTO get(Long id)
    {
        if (id == null) throw new NullPointerException("ID is null.");
        
        CaloriesTableDTO caloriesTableDTO = null;
        
        CaloriesTable caloriesTable = caloriesTableDAO.get(id);
        caloriesTableDTO = CaloriesTableDTOChanger.entityToDTO(caloriesTable);
        
        return caloriesTableDTO;        
    }      
    
    public void update(CaloriesTableDTO caloriesTableDTO)
    {
        if (caloriesTableDTO == null) throw new NullPointerException("CaloriesTable is null.");
        
        CaloriesTable caloriesTable = CaloriesTableDTOChanger.dtoToEntity(caloriesTableDTO);
        caloriesTableDAO.update(caloriesTable);        
    }    
        
    public void delete(CaloriesTableDTO caloriesTableDTO)
    {
        if (caloriesTableDTO == null) throw new NullPointerException("CaloriesTable is null.");
        
        CaloriesTable caloriesTable = CaloriesTableDTOChanger.dtoToEntity(caloriesTableDTO);
        caloriesTableDAO.delete(caloriesTable);        
    }         
    
    public List<CaloriesTableDTO> findAll()
    {
        List<CaloriesTableDTO> caloriesTableDTOList = new ArrayList<CaloriesTableDTO>();
        List<CaloriesTable> caloriesTableList = new ArrayList<CaloriesTable>();
        
        caloriesTableList = caloriesTableDAO.findAll();
        caloriesTableDTOList = CaloriesTableDTOChanger.entityListToDTOList(caloriesTableList);
        
        return caloriesTableDTOList;        
    }        
}
