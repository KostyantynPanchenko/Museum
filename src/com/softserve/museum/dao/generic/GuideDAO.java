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
import java.time.LocalDateTime;
import java.util.List;

import com.softserve.museum.domain.Guide;
import com.softserve.museum.domain.Position;

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

    /**
     * Finds all guides in given time slot.
     * @param start start of time slot
     * @param end end of time slot
     * @return list of guides
     */
    public abstract List<Guide> findByTime(LocalDateTime start, LocalDateTime end);

    /**
     * Finds all guides in given time slot.
     * @param start start of time slot
     * @param end end of time slot
     * @return list of guides
     */
	public abstract List<Guide> findByTime(Time start, Time end);

	
    @SuppressWarnings("rawtypes")
	public abstract List getCountGuidesByPeriod(LocalDateTime start, LocalDateTime end);

    @SuppressWarnings("rawtypes")
	public abstract List getCountTotalTimePerGuideByPeriod(LocalDateTime start,
    		LocalDateTime end);

    /**
     * Finds guide by given position.
     * @param thePosition guide's position
     * @return list of guides
     */
    public abstract List<Guide> findByPosition(Position thePosition);

}
