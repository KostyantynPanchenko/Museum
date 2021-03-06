/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.impl;

import java.time.LocalTime;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.softserve.museum.dao.generic.GuideDAO;
import com.softserve.museum.domain.Guide;
import com.softserve.museum.domain.GuideStatisticDTO;
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
     * Finds all available guides by given time slot
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

	/**
     * Returns all guides excursion statistic (total excursion number and duration)
     * by given time slot
     * @param start start of time slot
     * @param end end of time slot
     * @return list of proxy GuideStatisticDTO object
     */
	@SuppressWarnings("unchecked")
	@Override
	public List<GuideStatisticDTO> getGuidesStatisticByPeriod(LocalDateTime start, LocalDateTime end) {
		StringBuilder query = new StringBuilder(
				"SELECT XS.guide.firstName AS firstName, XS.guide.lastName AS lastName, COUNT(id) AS totalExcursions, "
						+ "SUM(XS.details.durationSec) AS excursionsTotalDuration " + "FROM Excursion AS XS "
						+ "WHERE (XS.start >= :startDate AND XS.end <= :endDate) GROUP BY XS.guide");
		System.out.println(query.toString());
		Query result = sessionFactory.getCurrentSession().createQuery(query.toString());
		result.setTimestamp("startDate", Timestamp.valueOf(start));
		result.setTimestamp("endDate", Timestamp.valueOf(end));
		List<GuideStatisticDTO> returnResult = new ArrayList<GuideStatisticDTO>();
		for (Object[] obj : (List<Object[]>) result.list()) {
			GuideStatisticDTO listElement = new GuideStatisticDTO();
			listElement.setFirstName(String.valueOf(obj[0]));
			listElement.setLastName(String.valueOf(obj[1]));
			listElement.setTotalExcursions((long) obj[2]);
			listElement.setExcursionsTotalDuration(LocalTime.MIN.plusSeconds((long) obj[3]));
			returnResult.add(listElement);

		}

		return returnResult;
		// return result.list();
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
     * Finds all guides by given position.
     * @param thePosition guide's position to search upon
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
     * Finds all available guides by given time slot
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
