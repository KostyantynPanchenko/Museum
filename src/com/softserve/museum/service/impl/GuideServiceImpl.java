/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.museum.dao.generic.ExcursionDAO;
import com.softserve.museum.dao.generic.GuideDAO;
import com.softserve.museum.domain.Excursion;
import com.softserve.museum.domain.Guide;
import com.softserve.museum.domain.GuideStatisticDTO;
import com.softserve.museum.domain.Position;
import com.softserve.museum.service.GuideService;

/**
 * 
 * Exhibit service implementation.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 24.10.2016
 *
 */
@Service
public class GuideServiceImpl implements GuideService {

    @Autowired
    private GuideDAO guides;
    
    @Autowired
    private ExcursionDAO excursions;
    
    /**
     * Finds all guides.
     * @return list of all guides
     */
    @Override
    public List<Guide> listGuides() {
        return guides.getAll();
    }
    
    /**
     * Finds all guides in given time slot.
     * @param start start of time slot
     * @param end end of time slot
     * @return list of guides
     */
    @Override
    public List<Guide> findByTime(LocalDateTime start, LocalDateTime end) {
        List<Excursion> eList = excursions.findInPeriod(start, end);        
        List<Guide> gList = guides.getAll();
        
        for (Excursion e: eList) {
            gList.remove(e.getGuide());
        }
        
        return gList;
    }
    

    /**
     * Finds all guides in given time slot.
     * @param start start of time slot
     * @param end end of time slot
     * @return list of guides
     */
    @Override
    public List<Guide> findByTime(String start, String end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startTime = LocalDateTime.parse(start, formatter);
        LocalDateTime endTime = LocalDateTime.parse(end, formatter);
        
        return findByTime(startTime, endTime);
    }


    /**
     * Return statistic about all guides excursions in given time slot.
     * @param start start of time slot
     * @param end end of time slot
     * @return list of proxy object GuideStatisticDTO
     */
    @Override
	public List<GuideStatisticDTO> getGuidesStatisticByPeriod(LocalDateTime start, LocalDateTime end) {
		return guides.getGuidesStatisticByPeriod(start, end);
	}

	@SuppressWarnings("rawtypes")
	@Override
    public List getCountTotalTimePerGuideByPeriod(LocalDateTime start, LocalDateTime end) {
        return guides.getCountTotalTimePerGuideByPeriod(start, end);
    }

    /**
     * Makes given guide persistent.
     * @param guide instance to be persisted
     * @return guide's id
     */
    @Override
    public Integer save(Guide guide) {
        return guides.save(guide);
    }

    /**
     * Updates given instance.
     * @param guide instance to be persisted
     * @return updated instance
     */
    @Override
    public Guide update(Guide guide) {
        return guides.update(guide);
    }

    /**
     * Deleted given instance.
     * @param guide instance to be deleted
     */
    @Override
    public void delete(Guide guiden) {
        guides.delete(guiden);
    }

    /**
     * Finds guide by given position.
     * @param position guide's position
     * @return list of guides
     */
    @Override
    public List<Guide> findByPosition(String position) {
        Position thePosition;
        
        switch (position.trim().toUpperCase()) {
        case "MANAGER":
            thePosition = Position.MANAGER;
            break;
        case "GUIDE":
            thePosition = Position.GUIDE;
            break;
        case "CHIEF GUIDE":
            thePosition = Position.CHIEF_GUIDE;
            break;
        default:
            return null;
        }
        
        return guides.findByPosition(thePosition);         
    }

}
