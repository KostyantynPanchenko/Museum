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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        return new ModelAndView("guides/guides", "guides", guideService.listGuides());
    }
    
    @GetMapping("/available")
    public String showAvailableForm(Model model) {
        return "guides/guidesAvailable";
    }
    
    @PostMapping("/available")
    public ModelAndView findAvailable(
            @RequestParam(name="start") String start, 
            @RequestParam(name="end") String end) {
        
        ModelAndView model = new ModelAndView("guides/guidesAvailableResults");
        start = start.replace('T', ' ');
        end = end.replace('T', ' ');
        model.addObject("start", start);
        model.addObject("end", end);
        model.addObject("guides", guideService.findByTime(start, end));
        return model;
    }
    
    @GetMapping("/position")
    public String showPositionForm() {
        return "guides/guidesByPosition";
    }
    
    @PostMapping("/position")
    public String processPositionForm(@RequestParam(name="position") String position, RedirectAttributes model) {
        model.addAttribute("position", position);
        return "redirect:/guides/position/{position}";
    }
    
    @GetMapping("/position/{position}")
    public ModelAndView showGuideByPosition(@PathVariable("position") String position) {
        ModelAndView model = new ModelAndView("guides/guidesByPositionResults");
        model.addObject("position", position);
        model.addObject("guides", guideService.findByPosition(position));
        return model;
    }    
    
}
