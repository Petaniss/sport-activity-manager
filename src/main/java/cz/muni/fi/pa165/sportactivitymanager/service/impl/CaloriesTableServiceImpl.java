
package cz.muni.fi.pa165.sportactivitymanager.service.impl;

import cz.muni.fi.pa165.sportactivitymanager.CaloriesTable;
import cz.muni.fi.pa165.sportactivitymanager.dao.CaloriesTableDAO;
import cz.muni.fi.pa165.sportactivitymanager.dto.CaloriesTableDTO;
import cz.muni.fi.pa165.sportactivitymanager.service.CaloriesTableService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gallen
 */
public class CaloriesTableServiceImpl implements CaloriesTableService
{
    private CaloriesTableDAO caloriesTableDAO;
    
    public CaloriesTableDAO getDAO()                      { return caloriesTableDAO; }    
    public void setDAO(CaloriesTableDAO caloriesTableDAO) { this.caloriesTableDAO = caloriesTableDAO; }
       
    public void create(CaloriesTableDTO caloriesTableDTO)
    {
        CaloriesTable caloriesTable = dtoToEntity(caloriesTableDTO);
        caloriesTableDAO.create(caloriesTable);
        caloriesTableDTO.setId(caloriesTable.getId());        
    }    
    
    public CaloriesTableDTO get(Long id)
    {
        if (id == null) throw new NullPointerException("ID is null.");
        
        CaloriesTableDTO caloriesTableDTO = null;
        
        CaloriesTable caloriesTable = caloriesTableDAO.get(id);
        caloriesTableDTO = entityToDTO(caloriesTable);
        
        return caloriesTableDTO;        
    }      
    
    public void update(CaloriesTableDTO caloriesTableDTO)
    {
        if (caloriesTableDTO == null) throw new NullPointerException("CaloriesTable is null.");
        
        CaloriesTable caloriesTable = dtoToEntity(caloriesTableDTO);
        caloriesTableDAO.update(caloriesTable);        
    }    
        
    public void delete(CaloriesTableDTO caloriesTableDTO)
    {
        if (caloriesTableDTO == null) throw new NullPointerException("CaloriesTable is null.");
        
        CaloriesTable caloriesTable = dtoToEntity(caloriesTableDTO);
        caloriesTableDAO.delete(caloriesTable);        
    }         
    
    public List<CaloriesTableDTO> findAll()
    {
        List<CaloriesTableDTO> caloriesTableDTOList = new ArrayList<CaloriesTableDTO>();
        List<CaloriesTable> caloriesTableList = new ArrayList<CaloriesTable>();
        
        caloriesTableList = caloriesTableDAO.findAll();
        caloriesTableDTOList = entityListToDTOList(caloriesTableList);
        
        return caloriesTableDTOList;        
    }
    
    public static CaloriesTable dtoToEntity(CaloriesTableDTO caloriesTableDTO)
    {
        if (caloriesTableDTO == null) return null;
                
        CaloriesTable caloriesTable = new CaloriesTable();
        caloriesTable.setId(caloriesTableDTO.getId());
        caloriesTable.setCalories60Kg(caloriesTableDTO.getCalories60Kg());
        caloriesTable.setCalories70Kg(caloriesTableDTO.getCalories70Kg());
        caloriesTable.setCalories80Kg(caloriesTableDTO.getCalories80Kg());
        caloriesTable.setCalories90Kg(caloriesTableDTO.getCalories90Kg());
        caloriesTable.setGender(caloriesTableDTO.getGender());  
        
        return caloriesTable;
    }
    
    public static CaloriesTableDTO entityToDTO(CaloriesTable caloriesTable)
    {
        if (caloriesTable ==  null) return null;
        
        CaloriesTableDTO caloriesTableDTO = new CaloriesTableDTO();
        caloriesTableDTO.setId(caloriesTable.getId());
        caloriesTableDTO.setCalories60Kg(caloriesTable.getCalories60Kg());
        caloriesTableDTO.setCalories70Kg(caloriesTable.getCalories70Kg());
        caloriesTableDTO.setCalories80Kg(caloriesTable.getCalories80Kg());
        caloriesTableDTO.setCalories90Kg(caloriesTable.getCalories90Kg());
        caloriesTableDTO.setGender(caloriesTable.getGender());
        
        return caloriesTableDTO;       
    }
    
    public static List<CaloriesTableDTO> entityListToDTOList(List<CaloriesTable> tables)
    {
        if (tables == null) return null;
        
        List<CaloriesTableDTO> tablesDTOList = new ArrayList<CaloriesTableDTO>();
        for (int i = 0; i < tables.size(); i++)
        {
            tablesDTOList.add(entityToDTO(tables.get(i)));
        }
        
        return tablesDTOList;        
    }    
}
