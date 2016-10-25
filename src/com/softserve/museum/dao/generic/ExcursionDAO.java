/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.generic;

import java.sql.Time;
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

    public abstract List<Excursion> findExcursionByTime(Time start, Time end);

    public abstract List<Excursion> findExcursionByStart(Time start);

}
