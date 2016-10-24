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

import com.softserve.museum.dao.generic.GuideDAO;
import com.softserve.museum.domain.Guide;
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
    
    @Override
    public List<Guide> listGuides() {
        return guides.getAll();
    }

    @Override
    public List<Guide> findGuideByTime(Time start, Time end) {
        return guides.findGuideByTime(start, end);
    }

    @Override
    public int getCountGuidesByPeriod(Time start, Time end) {
        return guides.getCountGuidesByPeriod(start, end);
    }

    @Override
    public List<Guide> getCountTotalTimePerGuideByPeriod(Time start, Time end) {
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

}
