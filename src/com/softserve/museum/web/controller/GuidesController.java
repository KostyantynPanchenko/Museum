/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */

package com.softserve.museum.web.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.museum.domain.Guide;
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
@RequestMapping(path = "/guides")
public class GuidesController {
      
    @Autowired
    private GuideService guideService;
    
    @GetMapping
    public ModelAndView onGuides() {
        ModelAndView model = new ModelAndView("guides/guides");
        List<Guide> guides = guideService.listGuides();
        model.addObject("guides", guides);
        return model;
    }
    
    @GetMapping("/all")
    public ModelAndView all() {
        ModelAndView model = new ModelAndView("guides/guides");
        List<Guide> guides = guideService.listGuides();
        model.addObject("guides", guides);
        return model;
    }
    
    @GetMapping("/available")
    public ModelAndView onAvailable() {
        ModelAndView model = new ModelAndView("guides/guidesAvailable");
        List<Guide> guides = guideService.listGuides();
        model.addObject("guides", guides);
        return model;
    }
    
    @PostMapping("/available")
    public ModelAndView findAvailable(@RequestParam(name="start") String input) {
        String str = input.replace('T', ' ');
        System.out.println(str);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime start = LocalDateTime.parse(str, formatter);
        System.out.println(start);
        ModelAndView model = new ModelAndView("guides/guidesAvailable");
        List<Guide> guides = guideService.listGuides();
        model.addObject("guides", guides);
        return model;
    }
    
    @GetMapping("/position")
    public String onPosition() {
        return "guides/guidesByPosition";
    }
    
    @PostMapping("/position")
    public ModelAndView onPosition(@RequestParam(name="position") String position) {
        ModelAndView model = new ModelAndView("guides/guidesByPositionResults");
        model.addObject("position", position);
        
        List<Guide> guides = guideService.findByPosition(position);
        
        model.addObject("guides", guides);
        return model;
    }
}
