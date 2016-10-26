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

    public abstract Integer save(Excursion excursion);
    
    public abstract Excursion update(Excursion excursion);
    
    public abstract void delete(Excursion excursion);
    
    public abstract List<ExcursionDetails> listExcursions();
    
    public abstract List<Excursion> findByTimeSlot(LocalDateTime start, LocalDateTime end);
    
    public abstract List<Excursion> findByStart(LocalDateTime start);
    
    public abstract List<Excursion> findByEnd(LocalDateTime end);

    public abstract List<Excursion> listSchedule();
}
