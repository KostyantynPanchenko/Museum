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

import com.softserve.museum.domain.Material;

/**
 * 
 * Material service.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 24.10.2016
 *
 */
public interface MaterialService {

    /**
     * Finds all materials
     * @return <code>List&lt;Material&gt;</code>of all materials
     */
    public abstract List<Material> listMaterials();

    /**
     * Finds all materials
     * @param m given material name
     * @return <code>List&lt;Material&gt;</code>of all materials by given name
     */
    public abstract List<Material> findMaterialByName(String m);

}
