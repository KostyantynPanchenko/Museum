/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * Utility class which converts LocalDateTime to user friendly representation.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 21.10.2016 
 *
 */
public class LocalDateTimeCustomFormatter {
   
    private static final DateTimeFormatter patern = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    
    public LocalDateTimeCustomFormatter() {
        System.out.println("Formatter created");
    }
    
    public String format(LocalDateTime value) {
        return value.format(patern);
    }
}
