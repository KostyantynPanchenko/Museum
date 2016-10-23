/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.softserve.museum.dao.generic.TechniqueDAO;
import com.softserve.museum.domain.Technique;

/**
 * 
 * DAO class for Technique entity.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 23.10.2016
 *
 */
@Repository
@Transactional
public class TechniqueDAOimpl extends AbstractDAO<Technique, Integer> implements TechniqueDAO {

    public TechniqueDAOimpl() {
        super(Technique.class);
    }

}
