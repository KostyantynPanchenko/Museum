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

    public abstract List<Excursion> findByTimeSlot(LocalDateTime start, LocalDateTime end);

    public abstract List<Excursion> findByStart(LocalDateTime start);
    
    public abstract List<Excursion> findByEnd(LocalDateTime start);

    public abstract List<Excursion> findInPeriod(LocalDateTime start,
            LocalDateTime end);

}
