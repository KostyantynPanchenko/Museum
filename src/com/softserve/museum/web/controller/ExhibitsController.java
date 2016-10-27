/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */

package com.softserve.museum.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return new ModelAndView("exhibits/exhibitsAll", "exhibits", exhibitService.listExhibits());
    }

    @GetMapping("/author")
    public String byAuthor() {
        return "exhibits/exhibitsByAuthor";
    }

    @PostMapping("/author")
    public String byAuthorPost(@RequestParam("authorName") String author, RedirectAttributes model) {
        model.addAttribute("author", author);
        return "redirect:/exhibits/author/{author}";
    }

    @GetMapping("/author/{author}")
    public ModelAndView byAuthorResults(@PathVariable("author") String author) {
        ModelAndView model = new ModelAndView("exhibits/exhibitsByAuthorResults");
        model.addObject("author", author);
        model.addObject("exhibits", exhibitService.findExhibitByAuthor(author));
        return model;
    }

    @GetMapping("/material")
    public ModelAndView byMaterial() {
        return new ModelAndView("exhibits/exhibitsByMaterial", "materials", materialService.listMaterials());
    }

    @PostMapping("/material")
    public ModelAndView byMaterialPost(@RequestParam("chosenMaterials") String[] chosenMaterials) {
        return new ModelAndView("exhibits/exhibitsByMaterialResults", "exhibits", 
                exhibitService.findExhibitByMaterial(chosenMaterials));
    }

    @GetMapping("/technique")
    public ModelAndView byTechnique() {
        return new ModelAndView("exhibits/exhibitsByTechnique", "techniques",
                techniqueService.listTechniques());
    }

    @PostMapping("/technique")
    public String byTechniquePost(@RequestParam("technique") String technique, RedirectAttributes model) {
        model.addAttribute("technique", technique);
        return "redirect:/exhibits/technique/{technique}";
    }

    @GetMapping("/technique/{technique}")
    public ModelAndView byTechniqueResults(@PathVariable("technique") String technique) {
        ModelAndView model = new ModelAndView("exhibits/exhibitsByTechniqueResults");
        model.addObject("technique", technique);
        model.addObject("exhibits", exhibitService.findExhibitByTechniquel(technique));
        return model;
    }
}
