/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */

package com.softserve.museum.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.museum.domain.Exhibit;
import com.softserve.museum.domain.Material;
import com.softserve.museum.domain.Technique;
import com.softserve.museum.service.ExhibitService;
import com.softserve.museum.service.MaterialService;
import com.softserve.museum.service.TechniqueService;

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
    
    @Autowired
    private TechniqueService techniqueService;
    
    @Autowired
    private MaterialService materialService;
    
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
    
    @GetMapping("/author")
    public String byAuthorGet() {
        return "exhibits/exhibitsByAuthor";
    }
    
    @GetMapping("/author/{author}")
    public ModelAndView byAuthorName(@PathVariable("author") String author) {        
        return getExhibitsByAuthor(author);
    }
    
    @PostMapping("/author")
    public ModelAndView byAuthorPost(@RequestParam("authorName") String author) {
        return getExhibitsByAuthor(author);
    }
    
    private ModelAndView getExhibitsByAuthor(String author) {
        ModelAndView model = new ModelAndView("exhibits/exhibitsByAuthorResults");
        model.addObject("author", author);
        
        List<Exhibit> exhibits = exhibitService.findExhibitByAuthor(author);
        
        if (exhibits == null) {
            return model;
        }
        
        model.addObject("exhibits", exhibits);
        return model;
    }
    
    @GetMapping("/material")
    public ModelAndView byMaterialGet() {
        ModelAndView model = new ModelAndView("exhibits/exhibitsByMaterial");
        List<Material> materials = materialService.listMaterials();
        model.addObject("materials", materials);
        return model;
    }
    
    @PostMapping("/material")
    public ModelAndView byMaterialPost(@RequestParam("chosenMaterials") String[] chosenMaterials) {
        ModelAndView model = new ModelAndView("exhibits/exhibitsByMaterialResults");
        List<Exhibit> exhibits  = new ArrayList<>();
        
        for (String m: chosenMaterials){
            List<Exhibit> list = exhibitService.findExhibitByMaterial(m);            
            exhibits.addAll(list);
        }        
        
        model.addObject("exhibits", exhibits);
        return model;
    }
    
    @GetMapping("/technique")
    public ModelAndView byTechniqueGet() { 
        ModelAndView model = new ModelAndView("exhibits/exhibitsByTechnique");
        List<Technique> techniques = techniqueService.listTechniques();
        model.addObject("techniques", techniques);
        return model;
    }
    
    @PostMapping("/technique")
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
