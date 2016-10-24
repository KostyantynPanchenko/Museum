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

import com.softserve.museum.dao.generic.ExhibitDAO;
import com.softserve.museum.domain.Author;
import com.softserve.museum.domain.Exhibit;
import com.softserve.museum.domain.Material;
import com.softserve.museum.domain.Technique;
import com.softserve.museum.service.ExhibitService;

/**
 * 
 * Exhibit service implementation.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 24.10.2016
 *
 */
@Service
public class ExhibitServiceImpl implements ExhibitService {

    @Autowired
    private ExhibitDAO exhibits;
    
    @Override
    public List<Exhibit> listExhibits() {
        return exhibits.getAll();
    }

    @Override
    public List<Exhibit> findExhibitByAuthor(Author author) {
        return exhibits.findExhibitByAuthor(author);
    }

    @Override
    public List<Exhibit> findExhibitByMaterial(Material material) {
        return exhibits.findExhibitByMaterial(material);
    }

    @Override
    public List<Exhibit> findExhibitByTechnique(Technique technique) {
        return exhibits.findExhibitByTechnique(technique);
    }

    @Override
    public List<Exhibit> findExhibitByHall(Integer hallNumber) {
        return exhibits.findExhibitByHall(hallNumber);
    }

    @Override
    public Integer save(Exhibit exhibit) {
        return exhibits.save(exhibit);
    }

    @Override
    public Exhibit update(Exhibit exhibit) {
        return exhibits.update(exhibit);
    }

    @Override
    public void delete(Exhibit exhibit) {
        exhibits.delete(exhibit);
    }

}
