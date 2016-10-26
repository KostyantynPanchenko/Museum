/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.service.impl;

import java.sql.Time;
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
    
    @Override
    public List<ExcursionDetails> listExcursions() {
        return details.getAll();
    }

    @Override
    public List<Excursion> findExcursionByTime(Time start, Time end) {
        return excursions.findExcursionByTime(start, end);
    }

    @Override
    public List<Excursion> findExcursionByStart(Time start) {
        return excursions.findExcursionByStart(start);
    }

    @Override
    public List<Excursion> findExcursionByEnd(Time end) {
        return excursions.findExcursionByStart(end);
    }

    @Override
    public Integer save(Excursion excursion) {
        return excursions.save(excursion);
    }

    @Override
    public Excursion update(Excursion excursion) {
        return excursions.update(excursion);
    }

    @Override
    public void delete(Excursion excursion) {
        excursions.delete(excursion);
    }

    @Override
    public List<Excursion> listSchedule() {        
        return excursions.getAll();
    }

}
