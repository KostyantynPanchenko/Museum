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
import org.springframework.web.servlet.ModelAndView;

import com.softserve.museum.domain.Excursion;
import com.softserve.museum.domain.Exhibit;
import com.softserve.museum.domain.Guide;
import com.softserve.museum.service.ExcursionService;
import com.softserve.museum.service.ExhibitService;
import com.softserve.museum.service.GuideService;

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
public class CoreController {
    
    @Autowired
    private ExcursionService excursionService;
    
    @Autowired
    private ExhibitService exhibitService;
    
    @Autowired
    private GuideService guideService;
    
    @GetMapping("/")
    public ModelAndView onIndex() {
        testExhibits();
        testExcursions();
        ModelAndView model = new ModelAndView("index");        
        return model;
    }
    
    @GetMapping("tours")
    public ModelAndView onTours() {
        ModelAndView model = new ModelAndView("excursions/excursions");
        List<Excursion> excursions = excursionService.listExcursions();
        model.addObject("excursions", excursions);
        return model;
    }
    
    @GetMapping("guides")
    public ModelAndView onGuides() {
        ModelAndView model = new ModelAndView("guides/guides");
        List<Guide> guides = guideService.listGuides();
        model.addObject("guides", guides);
        return model;
    }
    
    @GetMapping("exhibits")
    public ModelAndView onExhibits() {
        ModelAndView model = new ModelAndView("exhibits/exhibits");
        List<Exhibit> exhibits = exhibitService.listExhibits();
        model.addObject("exhibits", exhibits);
        return model;
    }
    
    private void testExhibits() {
        System.out.println(" ++++++++++++++++  EXHIBITS   ++++++++++++++++");
        List<Exhibit> exhibits = exhibitService.listExhibits();
        for (Exhibit ex: exhibits) {
            System.out.println(ex);
        }
        System.out.println(" ++++++++++++++++ END OF TEST ++++++++++++++++");
    }
    
    private void testExcursions() {
        System.out.println(" ++++++++++++++++  HIBERNATE  ++++++++++++++++");
        List<Excursion> exs = excursionService.listExcursions();
        for (Excursion ex: exs) {
            System.out.println(ex);
        }
        System.out.println(" ++++++++++++++++ END OF TEST ++++++++++++++++");
    }
}
