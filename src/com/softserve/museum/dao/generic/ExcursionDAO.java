/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.generic;

import java.time.LocalDateTime;
import java.util.List;

import com.softserve.museum.domain.Excursion;

/**
 * 
 * Establish contract for Excursion class CRUD operations.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 23.10.2016
 *
 */
public interface ExcursionDAO extends GenericDAO<Excursion, Integer> {

    /**
     * Finds excursions which are available in given time slot.
     * @param start start of time slot
     * @param end end of time slot
     * @return list of Excursion objects 
     */
    public abstract List<Excursion> findByTimeSlot(LocalDateTime start, LocalDateTime end);

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
     * Finds all excursions which start or end in given period.
     * @param start start of time slot
     * @param end end of time slot
     * @return list of Excursion objects 
     */
    public abstract List<Excursion> findInPeriod(LocalDateTime start,
            LocalDateTime end);

}
