/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.museum.dao.generic.ExcursionDAO;
import com.softserve.museum.dao.generic.ExcursionDetailsDAO;
import com.softserve.museum.domain.Excursion;
import com.softserve.museum.domain.ExcursionDetails;
import com.softserve.museum.service.ExcursionService;

/**
 * 
 * Excursion service implementation.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 24.10.2016
 *
 */
@Service
public class ExcursionServiceImpl implements ExcursionService {

    @Autowired
    private ExcursionDAO excursions;
    
    @Autowired
    private ExcursionDetailsDAO details;
    
    /**
     * Lists all excursions
     * @return all excursions
     */
    @Override
    public List<ExcursionDetails> listExcursions() {
        return details.getAll();
    }

    /**
     * Finds excursions which are available in given time slot.
     * @param start start of time slot
     * @param end end of time slot
     * @return list of Excursion objects 
     */
    @Override
    public List<Excursion> findByTimeSlot(LocalDateTime start, LocalDateTime end) {
        return excursions.findByTimeSlot(start, end);
    }

    /**
     * Finds excursions which are available in given time slot.
     * @param start start of time slot
     * @param end end of time slot
     * @return list of Excursion objects 
     */
    @Override
    public List<Excursion> findByTimeSlot(String start, String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startTime = LocalDateTime.parse(start, formatter);
        LocalDateTime endTime = LocalDateTime.parse(end, formatter);
        return excursions.findByTimeSlot(startTime, endTime);
    }

    /**
     * Finds all excursions which start after given time.
     * @param start start of time slot
     * @return list of Excursion objects
     */
    @Override
    public List<Excursion> findByStart(LocalDateTime start) {
        return excursions.findByStart(start);
    }

    /**
     * Finds all excursions which start after given time.
     * @param end end of time slot
     * @return list of Excursion objects
     */
    @Override
    public List<Excursion> findByEnd(LocalDateTime end) {
        return excursions.findByEnd(end);
    }

    /**
     * Makes given Excursion instance persistent.
     * @param excursion instance to be persisted
     * @return generated id
     */
    @Override
    public Integer save(Excursion excursion) {
        return excursions.save(excursion);
    }

    /**
     * Updates given Excursion instance.
     * @param excursion instance to be updated
     * @return updated instance
     */
    @Override
    public Excursion update(Excursion excursion) {
        return excursions.update(excursion);
    }

    /**
     * Deletes given instance.
     * @param excursion instance to be deleted
     */
    @Override
    public void delete(Excursion excursion) {
        excursions.delete(excursion);
    }

    /**
     * Lists all excursions
     * @return all excursions
     */
    @Override
    public List<Excursion> listSchedule() {        
        return excursions.getAll();
    }

}
