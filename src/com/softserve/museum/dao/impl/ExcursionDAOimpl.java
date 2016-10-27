/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.softserve.museum.dao.generic.ExcursionDAO;
import com.softserve.museum.domain.Excursion;

/**
 * 
 * DAO class for Excursion entity.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 19.10.2016
 *
 */
@Repository
@Transactional
public class ExcursionDAOimpl extends AbstractDAO<Excursion, Integer>
        implements ExcursionDAO {

    protected ExcursionDAOimpl() {
        super(Excursion.class);
    }

    /**
     * Finds excursions which are available in given time slot.
     * @param start start of time slot
     * @param end end of time slot
     * @return list of Excursion objects 
     */
	@SuppressWarnings("unchecked")
    @Override
    public List<Excursion> findByTimeSlot(LocalDateTime start, LocalDateTime end) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Excursion.class);
		criteria.add(Restrictions.ge("start", start));
		criteria.add(Restrictions.le("end", end));
		return criteria.list();
    }

	/**
     * Finds all excursions which start after given time.
     * @param start start of time slot
     * @return list of Excursion objects
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Excursion> findByStart(LocalDateTime start) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Excursion.class);
        criteria.add(Restrictions.ge("start", start));
        return criteria.list();
    }

    /**
     * Finds all excursions which start after given time.
     * @param end end of time slot
     * @return list of Excursion objects
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Excursion> findByEnd(LocalDateTime end) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Excursion.class);
        criteria.add(Restrictions.le("end", end));
        return criteria.list();
    }
    
    /**
     * Finds all excursions which start or end in given period.
     * @param start start of time slot
     * @param end end of time slot
     * @return list of Excursion objects 
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Excursion> findInPeriod(LocalDateTime start, LocalDateTime end) {
        String str = "select ex from Excursion ex "
                + "where (ex.start >= :st and ex.start <= :ending) "
                + "or (ex.end >= :st and ex.end <= :ending)";
        Query query = sessionFactory.getCurrentSession().createQuery(str);
        query.setParameter("st", start).setParameter("ending", end);
        return query.list();
    }

}
