/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.museum.dao.generic.AuthorDAO;
import com.softserve.museum.dao.generic.ExhibitDAO;
import com.softserve.museum.dao.generic.MaterialDAO;
import com.softserve.museum.dao.generic.TechniqueDAO;
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
    
    @Autowired
    private AuthorDAO authors;
    
    @Autowired
    private MaterialDAO materials;
    
    @Autowired
    private TechniqueDAO techniques;
    
    /**
     * Finds all exhibits.
     * @return list of all exhibits
     */
    @Override
    public List<Exhibit> listExhibits() {
        return exhibits.getAll();
    }

    /**
     * Finds exhibits by given Author.
     * @param author Author instance to search upon
     * @return list of exhibits
     */
    @Override
    public List<Exhibit> findExhibitByAuthor(Author author) {
        return exhibits.findExhibitByAuthor(author);
    }
    
    /**
     * Finds exhibits by given Author's name.
     * @param author Author's name to search upon
     * @return list of exhibits
     */
    @Override
    public List<Exhibit> findExhibitByAuthor(String author) {
        List<Author> list = authors.findAuthorByName(author);
        if (list == null || list.size() < 1) {
            return null;
        }
        return exhibits.findExhibitByAuthor(list.get(0));
    }

    /**
     * Finds exhibits by given Material.
     * @param material Material instance to search upon
     * @return list of exhibits
     */
    @Override
    public List<Exhibit> findExhibitByMaterial(Material material) {
        return exhibits.findExhibitByMaterial(material);
    }

    /**
     * Finds exhibits by given Material's name.
     * @param material Material's name to search upon
     * @return list of exhibits
     */
    @Override
    public List<Exhibit> findExhibitByMaterial(String material) {
        List<Material> list = materials.findMaterialByName(material);
        if (list == null || list.size() < 1) {
            return null;
        }
        return exhibits.findExhibitByMaterial(list.get(0));
    }
    
    /**
     * Finds exhibits by given Materials' names.
     * @param chosenMaterials Materials' names to search upon
     * @return list of exhibits
     */
    @Override
    public List<Exhibit> findExhibitByMaterials(String[] chosenMaterials) {
        List<Material> list = new ArrayList<>();
        
        for (String s: chosenMaterials) {
            list.add(materials.findMaterialByName(s).get(0));
        }
        
        return exhibits.findExhibitByMaterials(list);
    }

    /**
     * Finds exhibits by given Technique.
     * @param material Technique instance to search upon
     * @return list of exhibits
     */
    @Override
    public List<Exhibit> findExhibitByTechnique(Technique technique) {
        return exhibits.findExhibitByTechnique(technique);
    }

    /**
     * Finds exhibits by given Technique's name.
     * @param material Technique name to search upon
     * @return list of exhibits
     */
    @Override
    public List<Exhibit> findExhibitByTechniquel(String technique) {
        List<Technique> list = techniques.findTechniqueByName(technique);
        if (list == null || list.size() < 1) {
            return null;
        }
        return exhibits.findExhibitByTechnique(list.get(0));
    }
    
    /**
     * Finds all exhibits by hall number.
     * @param hallNumber given hall's number
     * @return list of exhibits
     */
    @Override
    public List<Exhibit> findExhibitByHall(Integer hallNumber) {
        return exhibits.findExhibitByHall(hallNumber);
    }

    /**
     * Makes given instance persisted.
     * @param exhibit instance to be persisted
     * @return persisted instance
     */
    @Override
    public Integer save(Exhibit exhibit) {
        return exhibits.save(exhibit);
    }

    /**
     * Updates given instance.
     * @param exhibit instance to be updated
     * @return updated instance
     */
    @Override
    public Exhibit update(Exhibit exhibit) {
        return exhibits.update(exhibit);
    }

    /**
     * Deletes given instance.
     * @param exhibit instance to be deleted
     */
    @Override
    public void delete(Exhibit exhibit) {
        exhibits.delete(exhibit);
    }

}
