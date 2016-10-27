/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.generic;

import java.util.List;

import com.softserve.museum.domain.Material;

/**
 * 
 * Establish contract for Material class CRUD operations.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 15.10.2016
 *
 */
public interface MaterialDAO extends GenericDAO<Material, Integer> {

    /**
     * Finds materials by given name
     * @param material material's name
     * @return list of materials
     */
    public abstract List<Material> findMaterialByName(String material);

}
