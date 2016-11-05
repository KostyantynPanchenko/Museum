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

import com.softserve.museum.domain.Guide;
import com.softserve.museum.domain.GuideStatisticDTO;

/**
 * 
 * Excursion service.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 24.10.2016
 *
 */
public interface GuideService {

    /**
     * Makes given guide persistent.
     * @param guide instance to be persisted
     * @return guide's id
     */
	public abstract Integer save(Guide guide);

	/**
	 * Updates given instance.
	 * @param guide instance to be persisted
	 * @return updated instance
	 */
	public abstract Guide update(Guide guide);

	/**
	 * Deleted given instance.
	 * @param guide instance to be deleted
	 */
	public abstract void delete(Guide guide);

	/**
	 * Finds all guides.
	 * @return list of all guides
	 */
	public abstract List<Guide> listGuides();

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
    public abstract List<Guide> findByTime(String start, String end);

	public abstract List<GuideStatisticDTO> getGuidesStatisticByPeriod(LocalDateTime start, LocalDateTime end);
	
	public abstract List<GuideStatisticDTO> getGuidesStatisticByPeriod(String start, String end);

/*	@SuppressWarnings("rawtypes")
	public abstract List getCountGuidesByPeriod(LocalDateTime start, LocalDateTime end);
*/
	@SuppressWarnings("rawtypes")
	public abstract List getCountTotalTimePerGuideByPeriod(LocalDateTime start, LocalDateTime end);

	/**
	 * Finds guide by given position.
	 * @param position guide's position
	 * @return list of guides
	 */
	public abstract List<Guide> findByPosition(String position);

}
