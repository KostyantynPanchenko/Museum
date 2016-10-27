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

import com.softserve.museum.domain.Author;
import com.softserve.museum.domain.Exhibit;
import com.softserve.museum.domain.Material;
import com.softserve.museum.domain.Technique;

/**
 * 
 * Establish contract for Exhibit class CRUD operations.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 23.10.2016
 *
 */
public interface ExhibitDAO extends GenericDAO<Exhibit, Integer> {

    /**
     * Finds exhibits by given Author.
     * @param author Author instance to search upon
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByAuthor(Author author);

    /**
     * Finds exhibits by given Material.
     * @param material Material instance to search upon
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByMaterial(List<Material> materials);
    
    /**
     * Finds exhibits by given Technique.
     * @param technique Technique instance to search upon
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByTechnique(Technique technique);

    /**
     * Finds all exhibits by hall number.
     * @param hallNumber given hall's number
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByHall(Integer hallNumber);

}
