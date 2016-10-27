/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.service;

import java.util.List;

import com.softserve.museum.domain.Technique;

/**
 * 
 * Technique service.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 24.10.2016
 *
 */public interface TechniqueService {

     /**
      * Finds all techniques
      * @return list <code>List&lt;Technique&gt;</code>of all techniques
      */
    public abstract List<Technique> listTechniques();

}
