/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.generic;

import com.softserve.museum.domain.Exhibit;

/**
 * 
 * Establish contract for Exhibit class CRUD operations.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 15.10.2016
 *
 */
public interface ExhibitDAO extends GenericDAO<Exhibit, Integer> {

}
