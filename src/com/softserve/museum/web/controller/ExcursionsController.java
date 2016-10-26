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

import com.softserve.museum.domain.Excursion;
import com.softserve.museum.domain.ExcursionDetails;
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
      
    @Autowired
    private ExcursionService excursionService;
    
    @GetMapping("/all")
    public ModelAndView all() {        
        ModelAndView model = new ModelAndView("excursions/excursionsAll");
        List<Excursion> excursions = excursionService.listSchedule();
        model.addObject("excursions", excursions);
        return model;
    }
    
    @GetMapping()
    public ModelAndView onTours() {
        ModelAndView model = new ModelAndView("excursions/excursions");
        List<ExcursionDetails> excursions = excursionService.listExcursions();
        model.addObject("excursions", excursions);
        return model;
    }
    
    @GetMapping("/timeslot")
    public String onTimeslotGet() {
        return "excursions/excursionsInSlot";
    }
    
    @PostMapping("/timeslot")
    public ModelAndView onTimeslotPost(
            @RequestParam(name="start") String start, 
            @RequestParam(name="end") String end) {
        
        ModelAndView model = new ModelAndView("excursions/excursionsInSlotResults");
        start = start.replace('T', ' ');
        end = end.replace('T', ' ');
        model.addObject("start", start);
        model.addObject("end", end);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startTime = LocalDateTime.parse(start, formatter);
        LocalDateTime endTime = LocalDateTime.parse(end, formatter);
                
        List<Excursion> excursions = excursionService.findByTimeSlot(startTime, endTime);
        model.addObject("excursions", excursions);
        return model;
  }  
     
}
