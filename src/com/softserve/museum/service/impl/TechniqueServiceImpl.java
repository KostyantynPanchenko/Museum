/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.museum.dao.generic.TechniqueDAO;
import com.softserve.museum.domain.Technique;
import com.softserve.museum.service.TechniqueService;

/**
 * 
 * Technique service implementation.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 24.10.2016
 *
 */
@Service
public class TechniqueServiceImpl implements TechniqueService {

    @Autowired
    private TechniqueDAO techniques;
    
    /**
     * Finds all techniques
     * @return list <code>List&lt;Technique&gt;</code>of all techniques
     */
    @Override
    public List<Technique> listTechniques() {       
        return techniques.getAll();
    }

}
