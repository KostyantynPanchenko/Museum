/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.softserve.museum.dao.generic.AuthorDAO;
import com.softserve.museum.domain.Author;

/**
 * 
 * DAO class for Guide entity.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 23.10.2016
 *
 */
@Repository
@Transactional
public class AuthorDAOimpl extends AbstractDAO<Author, Integer> implements AuthorDAO {

	protected AuthorDAOimpl() {
		super(Author.class);
	}

	/**
     * Finds authors by name.
     * @param name author's name
     * @return list of matching authors
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Author> findAuthorByName(String name) {        
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Author.class);
        criteria.add(Restrictions.eq("name", name));
        return criteria.list();
    }	

}
