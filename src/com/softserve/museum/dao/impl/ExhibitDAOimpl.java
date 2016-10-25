/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.impl;

//import java.beans.Expression;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.springframework.stereotype.Repository;

import com.softserve.museum.dao.generic.ExhibitDAO;
import com.softserve.museum.domain.Author;
import com.softserve.museum.domain.Exhibit;
import com.softserve.museum.domain.Material;
import com.softserve.museum.domain.Technique;

/**
 * 
 * DAO class for Exhibit entity.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 19.10.2016
 *
 */
@SuppressWarnings("deprecation")
@Repository
@Transactional
public class ExhibitDAOimpl extends AbstractDAO<Exhibit, Integer> implements ExhibitDAO {

	public ExhibitDAOimpl() {
		super(Exhibit.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Exhibit> findExhibitByAuthor(Author author) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Exhibit.class);
		criteria.add(Expression.eq("author", author));

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Exhibit> findExhibitByMaterial(Material material) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Exhibit.class);
		criteria.add(Expression.eq("material", material));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
    @Override
	public List<Exhibit> findExhibitByTechnique(Technique technique) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Exhibit.class);
		criteria.add(Expression.eq("technique", technique));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Exhibit> findExhibitByHall(Integer hallNumber) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Exhibit.class);
		criteria.add(Expression.eq("hall", hallNumber));
		return criteria.list();
	}

}
