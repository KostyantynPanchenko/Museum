/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.domain;

/**
 * 
 * Emun, represents museum guide's position.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 22.10.2016
 *
 */
public enum Position {
    MANAGER("Manager"), 
    CHIEF_GUIDE("Chief guide"), 
    GUIDE("Guide");
    
    private String desc;
    
    private Position(String desc) {
        this.desc = desc;
    }
    
    @Override
    public String toString() {
        return this.desc;
    }
}
