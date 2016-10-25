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

import com.softserve.museum.domain.Author;
import com.softserve.museum.domain.Excursion;
import com.softserve.museum.domain.Exhibit;
import com.softserve.museum.domain.Guide;
//import com.softserve.museum.domain.Material;
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
        testExhibitsByAuthor();
        ModelAndView model = new ModelAndView("index");
        return model;
    }
    
    @GetMapping("tours")
    public String onTours() {
        return "excursions/excursions";
    }
    
    @GetMapping("guides")
    public String onGuides() {
        return "guides/guides";
    }
    
    @GetMapping("exhibits")
    public String onExhibits() {
        return "exhibits/exhibits";
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
    private void testExhibitsByAuthor() {
        System.out.println(" ++++++++++++++++  HIBERNATE  ++++++++++++++++");
        Author testAuthor = new Author();
        int authorId = 1010;
        testAuthor.setId(authorId);
//      Material testMaterial = new Material();
      //int authorId = 1006;
 //     testMaterial.setId(new Integer(1006));
        System.out.println(" Set authorID" + testAuthor.getId());
        List<Exhibit> exhibits = exhibitService.findExhibitByAuthor(testAuthor);
   //     List<Exhibit> exhibits = exhibitService.findExhibitByMaterial(testMaterial);
        for (Exhibit ex: exhibits) {
            System.out.println(ex);
        }
        System.out.println(" ++++++++++++++++ END OF TEST ++++++++++++++++");
    }
/*    private void testAuthors() {
        System.out.println(" ++++++++++++++++  HIBERNATE  ++++++++++++++++");
        Time formatter = SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        
        List<Guide> exs = guideService.findGuideByTime('2016-10-25 12:00:00', '2016-10-25 13:00:00');
        for (Excursion ex: exs) {
            System.out.println(ex);
        }
        System.out.println(" ++++++++++++++++ END OF TEST ++++++++++++++++");
    }
    */
}
