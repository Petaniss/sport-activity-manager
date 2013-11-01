/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.sportactivitymanager.service;

import cz.muni.fi.pa165.sportactivitymanager.SportRecord;
import cz.muni.fi.pa165.sportactivitymanager.dto.SportRecordTO;
import java.util.List;

/**
 *
 * @author Phaser
 */
public interface SportRecordService {

    void create(SportRecordTO sportRecordTO);

    SportRecordTO getSportRecord(Long id);

    void delete(SportRecordTO sportRecordTO);

    void delete(Long id);

    void update(SportRecordTO sportRecordTO);

    List<SportRecordTO> findAll();
}
