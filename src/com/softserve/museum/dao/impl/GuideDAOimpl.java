/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.impl;

import java.sql.Time;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.softserve.museum.dao.generic.GuideDAO;
import com.softserve.museum.domain.Guide;

/**
 * 
 * DAO class for Guide entity.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 23.10.2016
 *
 */
@Repository
@Transactional
public class GuideDAOimpl extends AbstractDAO<Guide, Integer> implements GuideDAO {

    protected GuideDAOimpl() {
        super(Guide.class);
    }

    @Override
    public List<Guide> findGuideByTime(Time start, Time end) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getCountGuidesByPeriod(Time start, Time end) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Guide> getCountTotalTimePerGuideByPeriod(Time start, Time end) {
        // TODO Auto-generated method stub
        return null;
    }

}
