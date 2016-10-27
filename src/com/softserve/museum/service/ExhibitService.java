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

import com.softserve.museum.domain.Author;
import com.softserve.museum.domain.Exhibit;
import com.softserve.museum.domain.Material;
import com.softserve.museum.domain.Technique;

/**
 * 
 * Exhibit service.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 24.10.2016
 *
 */
public interface ExhibitService {
    
    /**
     * Makes given instance persisted.
     * @param exhibit instane to be persisted
     * @return persisted instance
     */
    public abstract Integer save(Exhibit exhibit);
    
    /**
     * Updates given instance.
     * @param exhibit instance to be updated
     * @return updated instance
     */
    public abstract Exhibit update(Exhibit exhibit);
    
    /**
     * Deletes given instance.
     * @param exhibit instance to be deleted
     */
    public abstract void delete(Exhibit exhibit);

    /**
     * Finds all exhibits.
     * @return list of all exhibits
     */
    public abstract List<Exhibit> listExhibits();
    
    /**
     * Finds exhibits by given Author.
     * @param author Author instance to search upon
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByAuthor(Author author);
    
    /**
     * Finds exhibits by given Author's name.
     * @param author Author's name to search upon
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByAuthor(String author);
    
    /**
     * Finds exhibits by given Material.
     * @param material Material instance to search upon
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByMaterial(Material material);
    
    /**
     * Finds exhibits by given Material's name.
     * @param material Material's name to search upon
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByMaterial(String material);
    
    /**
     * Finds exhibits by given Technique.
     * @param material Technique instance to search upon
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByTechnique(Technique technique);

    /**
     * Finds exhibits by given Technique's name.
     * @param material Technique name to search upon
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByTechniquel(String technique);
    
    /**
     * Finds all exhibits by hall number.
     * @param hallNumber given hall's number
     * @return list of exhibits
     */
    public abstract List<Exhibit> findExhibitByHall(Integer hallNumber);
    
}
