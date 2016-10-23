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
    @JoinColumn(name = "details_id", referencedColumnName = "id")
    private ExcursionDetails details;
    
    @ManyToOne  
    @JoinColumn(name = "guide_id", referencedColumnName = "id")
    private Guide guide;
    
    /**
     * Default no-args constructor
     */
    public Excursion() { }

    public final int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public final LocalDateTime getStart() {
        return start;
    }

    public final void setStart(LocalDateTime start) {
        this.start = start;
    }

    public final LocalDateTime getEnd() {
        return end;
    }

    public final void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public final ExcursionDetails getDetails() {
        return details;
    }

    public final void setDetails(ExcursionDetails details) {
        this.details = details;
    }

    public final Guide getGuide() {
        return guide;
    }

    public final void setGuide(Guide guide) {
        this.guide = guide;
    }

    @Override
    public String toString() {
        return "Excursion with id=" + id 
                + ", starts at " + start + ", ends at " + end
                + ", tour name is '" + details.getName() + "', guide=" 
                + guide.getFirstName() + " " + guide.getLastName();
    }
    
    

}
