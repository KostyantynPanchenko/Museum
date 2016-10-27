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

    /** ExhibitService instance */
    @Autowired
    private ExhibitService exhibitService;

    /** TeqhniqueService instance */
    @Autowired
    private TechniqueService techniqueService;

    /** MaterialService instance */
    @Autowired
    private MaterialService materialService;

    /**
     * Handles request to "main" exhibits page. 
     * @return
     */
    @GetMapping()
    public String onExhibits() {
        return "exhibits/exhibits";
    }

    /**
     * Handles request to show all available exhibits
     * @return model and view
     */
    @GetMapping("/all")
    public ModelAndView all() {
        return new ModelAndView("exhibits/exhibitsAll", "exhibits", exhibitService.listExhibits());
    }

    /**
     * Handles request to page with searching by author form.
     * @return logical view name
     */
    @GetMapping("/author")
    public String byAuthor() {
        return "exhibits/exhibitsByAuthor";
    }

    /**
     * Processes post request to search exhibits by given author.
     * @param author author's name
     * @param model redirect model
     * @return logical view name (redirect to)
     */
    @PostMapping("/author")
    public String byAuthorPost(@RequestParam("authorName") String author, RedirectAttributes model) {
        model.addAttribute("author", author);
        return "redirect:/exhibits/author/{author}";
    }

    /**
     * Handles request to render results for searching exhibits by author.
     * @param author author
     * @return model and view
     */
    @GetMapping("/author/{author}")
    public ModelAndView byAuthorResults(@PathVariable("author") String author) {
        ModelAndView model = new ModelAndView("exhibits/exhibitsByAuthorResults");
        model.addObject("author", author);
        model.addObject("exhibits", exhibitService.findExhibitByAuthor(author));
        return model;
    }

    /**
     * Handles request to page with searching by material form.
     * @return logical view name
     */
    @GetMapping("/material")
    public ModelAndView byMaterial() {
        return new ModelAndView("exhibits/exhibitsByMaterial", "materials", materialService.listMaterials());
    }

    /**
     * Processes post request to search exhibits by given materials.
     * @param chosenMaterials array of given materials
     * @return model and view
     */
    @PostMapping("/material")
    public ModelAndView byMaterialPost(@RequestParam("chosenMaterials") String[] chosenMaterials) {
        return new ModelAndView("exhibits/exhibitsByMaterialResults", 
                "exhibits", exhibitService.findExhibitByMaterials(chosenMaterials));
    }

    /**
     * Handles request to page with searching by technique form.
     * @return model and view
     */
    @GetMapping("/technique")
    public ModelAndView byTechnique() {
        return new ModelAndView("exhibits/exhibitsByTechnique", "techniques", techniqueService.listTechniques());
    }

    /**
     * Processes post request to search exhibits by given author.
     * @param technique technique's name
     * @param model redirect model
     * @return logical view name (redirect to)
     */
    @PostMapping("/technique")
    public String byTechniquePost(@RequestParam("technique") String technique, RedirectAttributes model) {
        model.addAttribute("technique", technique);
        return "redirect:/exhibits/technique/{technique}";
    }

    /**
     * Handles request to render results for searching exhibits by technique.
     * @param technique technique
     * @return model and view
     */
    @GetMapping("/technique/{technique}")
    public ModelAndView byTechniqueResults(@PathVariable("technique") String technique) {
        ModelAndView model = new ModelAndView("exhibits/exhibitsByTechniqueResults");
        model.addObject("technique", technique);
        model.addObject("exhibits", exhibitService.findExhibitByTechniquel(technique));
        return model;
    }
}
