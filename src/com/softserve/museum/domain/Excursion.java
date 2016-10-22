/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * Entity class, represents museum's excursion.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 22.10.2016
 *
 */
@Entity
@Table(name = "excursions")
public class Excursion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int id;
    
    @Column
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime start;
    
    @Column
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime end;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "details_id")
    private ExcursionDetails details;
    
    @ManyToOne  
    @JoinColumn(name = "guide_id")
    private Guide guide;

}
