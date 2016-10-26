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
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.museum.dao.generic.ExcursionDAO;
import com.softserve.museum.dao.generic.GuideDAO;
import com.softserve.museum.domain.Excursion;
import com.softserve.museum.domain.Guide;
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
    
    @Override
    public List<Guide> listGuides() {
        return guides.getAll();
    }
    
    @Override
    public List<Guide> findByTime(LocalDateTime start,
            LocalDateTime end) {
        List<Excursion> eList = excursions.findInPeriod(start, end);
        
        for (Excursion e: eList) {
            System.out.println(e);
        }
        
        List<Guide> gList = guides.getAll();
        for (Guide g: gList) {
            System.out.println(g.getFirstName());
        }
        
        for (Excursion e: eList) {
            gList.remove(e.getGuide());
        }
        return gList;
    }

    @SuppressWarnings("rawtypes")
	@Override
    public List getCountGuidesByPeriod(LocalDateTime start, LocalDateTime end) {
        return guides.getCountGuidesByPeriod(start, end);
    }

    @SuppressWarnings("rawtypes")
	@Override
    public List getCountTotalTimePerGuideByPeriod(LocalDateTime start, LocalDateTime end) {
        return guides.getCountTotalTimePerGuideByPeriod(start, end);
    }

    @Override
    public Integer save(Guide guide) {
        return guides.save(guide);
    }

    @Override
    public Guide update(Guide guide) {
        return guides.update(guide);
    }

    @Override
    public void delete(Guide guiden) {
        guides.delete(guiden);
    }

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
