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

import com.softserve.museum.domain.Exhibit;
import com.softserve.museum.dao.generic.ExhibitDAO;

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
    private ExhibitDAO dao;
    
    @GetMapping("/")
    public ModelAndView onIndex() {
        testHibernate();
        ModelAndView model = new ModelAndView("index");
        return model;
    }
    
    private void testHibernate() {
        System.out.println(" ++++++++++++++++  HIBERNATE  ++++++++++++++++");
        List<Exhibit> exhibits = dao.getAll();
        for (Exhibit ex: exhibits) {
            System.out.println(ex);
        }
        System.out.println(" ++++++++++++++++ END OF TEST ++++++++++++++++");
    }
}
