/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * Entity class, represents museum exhibits.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 22.10.2016
 *
 */
@Entity
@Table(name = "exhibits")
public class Exhibit {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hall")
    private int hall;
    
    @Column(name = "name")
    private String name;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "author_id")
    private Author author;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "material_id")
    private Material material;
    
    @ManyToOne
    @JoinColumn(referencedColumnName = "technique_id")
    private Technique technique;
    
    /**
     * Default no-args constructor
     */
    public Exhibit() { }

    public final int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public final int getHall() {
        return hall;
    }

    public final void setHall(int hall) {
        this.hall = hall;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final Author getAuthor() {
        return author;
    }

    public final void setAuthor(Author author) {
        this.author = author;
    }

    public final Material getMaterial() {
        return material;
    }

    public final void setMaterial(Material material) {
        this.material = material;
    }

    public final Technique getTechnique() {
        return technique;
    }

    public final void setTechnique(Technique technique) {
        this.technique = technique;
    }
    
    
}
