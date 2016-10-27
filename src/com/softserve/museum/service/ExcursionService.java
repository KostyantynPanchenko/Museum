/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.service;

import java.time.LocalDateTime;
import java.util.List;

import com.softserve.museum.domain.Excursion;
import com.softserve.museum.domain.ExcursionDetails;

/**
 * 
 * Excursion service.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 24.10.2016
 *
 */
public interface ExcursionService {

    /**
     * Makes given Excursion instance persistent.
     * @param excursion instance to be persisted
     * @return generated id
     */
    public abstract Integer save(Excursion excursion);
    
    /**
     * Updates given Excursion instance.
     * @param excursion instance to be updated
     * @return updated instance
     */
    public abstract Excursion update(Excursion excursion);
    
    /**
     * Deletes given instance.
     * @param excursion instance to be deleted
     */
    public abstract void delete(Excursion excursion);
    
    /**
     * Returns list of all Excursions.
     * @return list of all Excursions
     */
    public abstract List<ExcursionDetails> listExcursions();
    
    /**
     * Finds excursions which are available in given time slot.
     * @param start start of time slot
     * @param end end of time slot
     * @return list of Excursion objects 
     */
    public abstract List<Excursion> findByTimeSlot(LocalDateTime start, LocalDateTime end);
    
    /**
     * Finds excursions which are available in given time slot.
     * @param start start of time slot
     * @param end end of time slot
     * @return list of Excursion objects 
     */
    public abstract List<Excursion> findByTimeSlot(String start, String end);
    
    /**
     * Finds all excursions which start after given time.
     * @param start start of time slot
     * @return list of Excursion objects
     */
    public abstract List<Excursion> findByStart(LocalDateTime start);
    
    /**
     * Finds all excursions which start after given time.
     * @param end end of time slot
     * @return list of Excursion objects
     */
    public abstract List<Excursion> findByEnd(LocalDateTime end);

    /**
     * Lists all excursions
     * @return all excursions
     */
    public abstract List<Excursion> listSchedule();
}
