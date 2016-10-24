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
    
    public abstract Integer save(Exhibit exhibit);
    
    public abstract Exhibit update(Exhibit exhibit);
    
    public abstract void delete(Exhibit exhibit);

    public abstract List<Exhibit> listExhibits();
    
    public abstract List<Exhibit> findExhibitByAuthor(Author author);
    
    public abstract List<Exhibit> findExhibitByMaterial(Material material);
    
    public abstract List<Exhibit> findExhibitByTechnique(Technique technique);
    
    public abstract List<Exhibit> findExhibitByHall(Integer hallNumber);
}
