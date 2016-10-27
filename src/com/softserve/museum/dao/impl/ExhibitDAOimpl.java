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
import org.hibernate.criterion.Restrictions;
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
@Repository
@Transactional
public class ExhibitDAOimpl extends AbstractDAO<Exhibit, Integer> implements ExhibitDAO {

	public ExhibitDAOimpl() {
		super(Exhibit.class);
	}

	/**
     * Finds exhibits by given author.
     * @param author Author object to search upon
     * @return list of exhibits
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<Exhibit> findExhibitByAuthor(Author author) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Exhibit.class);
		criteria.add(Restrictions.eq("author", author));

		return criteria.list();
	}

	/**
     * Finds exhibits by given material.
     * @param material material to search upon
     * @return list of exhibits
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<Exhibit> findExhibitByMaterial(Material material) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Exhibit.class);
		criteria.add(Restrictions.eq("material", material));
		return criteria.list();
	}

	/**
     * Finds exhibits by given list of materials.
     * @param materials list of materials
     * @return list of exhibits
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Exhibit> findExhibitByMaterials(List<Material> chosenMaterials) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Exhibit.class);
        criteria.add(Restrictions.in("material", chosenMaterials));
        return criteria.list();
    }
	
    /**
     * Finds exhibits by given technique
     * @param technique given technique
     * @return list of exhibits
     */
	@SuppressWarnings("unchecked")
    @Override
	public List<Exhibit> findExhibitByTechnique(Technique technique) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Exhibit.class);
		criteria.add(Restrictions.eq("technique", technique));
		return criteria.list();
	}

	/**
     * Finds exhibits by given hall number
     * @param hallNumber hall number
     * @return list of exhibits
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<Exhibit> findExhibitByHall(Integer hallNumber) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Exhibit.class);
		criteria.add(Restrictions.eq("hall", hallNumber));
		return criteria.list();
	}

}
