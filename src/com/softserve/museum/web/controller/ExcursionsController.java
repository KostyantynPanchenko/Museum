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
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.museum.domain.Excursion;
import com.softserve.museum.service.ExcursionService;

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
@RequestMapping(path = "/tours")
public class ExcursionsController {
    
    /** ExcursionService instance */
    @Autowired
    private ExcursionService excursionService;
    
    /**
     * Handles request to show all excursions (schedule).
     * @return model and view
     */
    @GetMapping("/all")
    public ModelAndView all() {        
        return new ModelAndView("excursions/excursionsAll", "excursions", excursionService.listSchedule());
    }
    
    /**
     * Handles request to "main" tours' page.
     * @return model and view
     */
    @GetMapping()
    public ModelAndView onTours() {
        return new ModelAndView("excursions/excursions", "excursions", excursionService.listExcursions());
    }
    
    /**
     * Handles request to search for excursions in given time slot, renders search form.
     * @return model and view
     */
    @GetMapping("/timeslot")
    public ModelAndView showTimeSlotForm() {
        ModelAndView model = new ModelAndView("excursions/excursionsInSlot");
        model.addObject("start", LocalDateTime.now());
        model.addObject("end", LocalDateTime.now().plusHours(2));
        return model;
    }
    
    /**
     * Handles request to process searching for excursions in time slot based on given input.
     * @param start start of time slot to search in
     * @param end end of time slot to search in
     * @return model and view
     */
    @PostMapping("/timeslot")
    public ModelAndView processTimeSlotSearchForm(
            @RequestParam(name="start") String start, 
            @RequestParam(name="end") String end) {
        
        ModelAndView model = new ModelAndView("excursions/excursionsInSlotResults");
        // trim milliseconds and delimiters 
        start = start.replace('T', ' ').substring(0, (start.length() - 7));
        end = end.replace('T', ' ').substring(0, (end.length() - 7));
        model.addObject("start", start);
        model.addObject("end", end);
                
        List<Excursion> excursions = excursionService.findByTimeSlot(start, end);
        model.addObject("excursions", excursions);
        return model;
  }  
     
}
