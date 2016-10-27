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
     * Finds exhibits by given author.
     * @param author Author object to search upon
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByAuthor(Author author);

    /**
     * Finds exhibits by given material.
     * @param material material to search upon
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByMaterial(Material material);
    
    /**
     * Finds exhibits by given list of materials.
     * @param materials list of materials
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByMaterials(List<Material> materials);

    /**
     * Finds exhibits by given technique
     * @param technique given technique
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByTechnique(Technique technique);

    /**
     * Finds exhibits by given hall number
     * @param hallNumber hall number
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByHall(Integer hallNumber);

}
