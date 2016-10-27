/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.generic;

import java.util.List;

import com.softserve.museum.domain.Author;

/**
 * 
 * Establish contract for Guided class CRUD operations.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 23.10.2016
 *
 */
public interface AuthorDAO extends GenericDAO<Author, Integer> {

    /**
     * Finds Author by name.
     * @param name Author's name
     * @return list of authors by given name
     */
    public abstract List<Author> findAuthorByName(String name);
}
