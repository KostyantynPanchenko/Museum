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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    
    /** GuideService instance */
    @Autowired
    private GuideService guideService;
    
    /**
     * Handles request to "main" guides page.
     * @return model and view
     */
    @GetMapping
    public ModelAndView onGuides() {
        return new ModelAndView("guides/guides", "guides", guideService.listGuides());
    }
    
    /**
     * Handles request to search for available guides (page with search form).
     * @param model model
     * @return logical view name
     */
    @GetMapping("/available")
    public ModelAndView showAvailableForm() {
        ModelAndView model = new ModelAndView("guides/guidesAvailable");
        model.addObject("start", LocalDateTime.now());
        model.addObject("end", LocalDateTime.now().plusHours(2));
        return model;
    }
    
    /**
     * Handles request to process finding of available guides.
     * @param start start of time slot to search in
     * @param end end of time slot to search in
     * @return model and view
     */
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
    
    /**
     * Handles request to searching guides by position (form page) 
     * @return logical view name
     */
    @GetMapping("/position")
    public String showPositionForm() {
        return "guides/guidesByPosition";
    }
    
    /**
     * Handles request to process searching of guides by position.
     * @param position guide's position to search upon
     * @param model model
     * @return path (redirect to) which will process results rendering
     */
    @PostMapping("/position")
    public String processPositionForm(@RequestParam(name="position") String position, RedirectAttributes model) {
        model.addAttribute("position", position);
        return "redirect:/guides/position/{position}";
    }
    
    /**
     * Handles request to render result of finding guides by position.
     * @param position path variable representing guide position
     * @return model and view
     */
    @GetMapping("/position/{position}")
    public ModelAndView showGuideByPosition(@PathVariable("position") String position) {
        ModelAndView model = new ModelAndView("guides/guidesByPositionResults");
        model.addObject("position", position);
        model.addObject("guides", guideService.findByPosition(position));
        return model;
    }    
    
}
