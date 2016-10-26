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

import com.softserve.museum.domain.Guide;

/**
 * 
 * Establish contract for Guided class CRUD operations.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 23.10.2016
 *
 */
public interface GuideDAO extends GenericDAO<Guide, Integer> {

    public abstract List<Guide> findGuideByTime(LocalDateTime start, LocalDateTime end);

    @SuppressWarnings("rawtypes")
	public abstract List getCountGuidesByPeriod(LocalDateTime start, LocalDateTime end);

    @SuppressWarnings("rawtypes")
	public abstract List getCountTotalTimePerGuideByPeriod(LocalDateTime start,
    		LocalDateTime end);

}
