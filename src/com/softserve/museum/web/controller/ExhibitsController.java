/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */

package com.softserve.museum.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.museum.domain.Exhibit;
import com.softserve.museum.service.ExhibitService;

/**
 * 
 * Core servlet controller class.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 22.10.2016
 *
 */
@Controller
@RequestMapping(path = "/exhibits")
public class ExhibitsController {
      
    @Autowired
    private ExhibitService exhibitService;
    
    @GetMapping()
    public String onExhibits() {        
        return "exhibits/exhibits";
    }
    
    @GetMapping("/all")
    public ModelAndView all() {
        ModelAndView model = new ModelAndView("exhibits/exhibitsAll");
        List<Exhibit> exhibits = exhibitService.listExhibits();
        model.addObject("exhibits", exhibits);
        return model;
    }
    
    @GetMapping("/byAuthor")
    public String byAuthorGet() {
        return "exhibits/exhibitsByAuthor";
    }
    
    @PostMapping("/byAuthor")
    public ModelAndView byAuthorPost(@RequestParam("authorName") String author) {
        ModelAndView model = new ModelAndView("exhibits/exhibitsByAuthorResults");
        model.addObject("author", author);
        
        List<Exhibit> exhibits = exhibitService.findExhibitByAuthor(author);
        
        if (exhibits == null) {
            return model;
        }
        
        model.addObject("exhibits", exhibits);
        return model;
    }
    
    @GetMapping("/byMaterial")
    public String byMaterialGet() {        
        return "exhibits/exhibitsByMaterial";
    }
    
    @PostMapping("/byMaterial")
    public ModelAndView byMaterialPost(@RequestParam("material") String material) {
        ModelAndView model = new ModelAndView("exhibits/exhibitsByMaterialResults");
        model.addObject("material", material);
        
        List<Exhibit> exhibits = exhibitService.findExhibitByMaterial(material);
        
        if (exhibits == null) {
            return model;
        }
        
        model.addObject("exhibits", exhibits);
        return model;
    }
    
    @GetMapping("/byTechnique")
    public String byTechniqueGet() {        
        return "exhibits/exhibitsByTechnique";
    }
    
    @PostMapping("/byTechnique")
    public ModelAndView byTechniquePost(@RequestParam("technique") String technique) {
        ModelAndView model = new ModelAndView("exhibits/exhibitsByTechniqueResults");
        model.addObject("technique", technique);
        
        List<Exhibit> exhibits = exhibitService.findExhibitByTechniquel(technique);
        
        if (exhibits == null) {
            return model;
        }
        
        model.addObject("exhibits", exhibits);
        return model;
    }
}
