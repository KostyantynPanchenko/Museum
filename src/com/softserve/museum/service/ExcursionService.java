/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.service;

import java.sql.Time;
import java.util.List;

import com.softserve.museum.domain.Excursion;

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
    
    public abstract List<Excursion> listExcursions();
    
    public abstract List<Excursion> findExcursionByTime(Time start, Time end);
    
    public abstract List<Excursion> findExcursionByStart(Time start);
    
    public abstract List<Excursion> findExcursionByEnd(Time end);
}
