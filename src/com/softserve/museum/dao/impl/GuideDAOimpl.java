/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.impl;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.softserve.museum.dao.generic.GuideDAO;
import com.softserve.museum.domain.Guide;
import com.softserve.museum.domain.Position;

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
public class GuideDAOimpl extends AbstractDAO<Guide, Integer> implements GuideDAO {

	protected GuideDAOimpl() {
		super(Guide.class);
	}

	/**
     * Finds all guides in given time slot.
     * @param start start of time slot
     * @param end end of time slot
     * @return list of guides
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<Guide> findByTime(LocalDateTime start, LocalDateTime end) {
		StringBuilder query = new StringBuilder(
				"FROM Guide WHERE id NOT IN (SELECT guide FROM Excursion AS XS WHERE (XS.start BETWEEN "
						+ ":startDate AND :endDate) OR (XS.end BETWEEN :startDate AND :endDate))");
		Query result = sessionFactory.getCurrentSession().createQuery(query.toString());
		result.setTimestamp("startDate", Timestamp.valueOf(start));
		result.setTimestamp("endDate", Timestamp.valueOf(end));

		return result.list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getCountGuidesByPeriod(LocalDateTime start, LocalDateTime end) {
		StringBuilder query = new StringBuilder(
				"SELECT gd.id, gd.firstName, gd.lastName, gd.position, COUNT(gd) AS cnt FROM Excursion AS XS RIGHT JOIN XS.guide AS gd "
						+ "WHERE (XS.start >= :startDate AND XS.end <= :endDate) " + "GROUP BY gd");
		Query result = sessionFactory.getCurrentSession().createQuery(query.toString());
		result.setTimestamp("startDate", Timestamp.valueOf(start));
		result.setTimestamp("endDate", Timestamp.valueOf(end));
		return result.list();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getCountTotalTimePerGuideByPeriod(LocalDateTime start, LocalDateTime end) {
		StringBuilder query = new StringBuilder(
				"SELECT gd.id, gd.firstName, gd.lastName, gd.position, SEC_TO_TIME(SUM(timestampdiff(SECOND, XS.start, XS.end))) AS totalduration FROM Excursion AS XS RIGHT JOIN XS.guide AS gd "
						+ "WHERE (XS.start >= :startDate AND XS.end <= :endDate) " + "GROUP BY gd");
		Query result = sessionFactory.getCurrentSession().createQuery(query.toString());
		result.setTimestamp("startDate", Timestamp.valueOf(start));
		result.setTimestamp("endDate", Timestamp.valueOf(end));
		return result.list();
	}

	/**
     * Finds guide by given position.
     * @param thePosition guide's position
     * @return list of guides
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Guide> findByPosition(Position thePosition) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Guide.class);
        criteria.add(Restrictions.eq("position", thePosition));
        return criteria.list();
    }
    
    /**
     * Finds all guides in given time slot.
     * @param start start of time slot
     * @param end end of time slot
     * @return list of guides
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<Guide> findByTime(Time start, Time end) {
		StringBuilder query = new StringBuilder(
				"FROM guides WHERE id NOT IN (SELECT guide_id FROM excursions AS XS WHERE (XS.start BETWEEN '");
		query.append(start.toString() + "' AND '");
		query.append(end.toString() + "') OR (XS.end BETWEEN '");
		query.append(start.toString() + "' AND '");
		query.append(end.toString() + "'))");
		Query result = sessionFactory.getCurrentSession().createQuery(query.toString());

		return result.list();
	}    
 
}
