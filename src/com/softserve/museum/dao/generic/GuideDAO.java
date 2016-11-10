/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.generic;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

import com.softserve.museum.domain.Guide;
import com.softserve.museum.domain.GuideStatisticDTO;
import com.softserve.museum.domain.Position;

/**
 * 
 * Establish contract for Guided class CRUD operations.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 23.10.2016
 *
 */
public interface GuideDAO extends GenericDAO<Guide, Integer> {

    /**ism thePosition guide's position to search upon
     * @return list of guides
     */
    public abstract List<Guide> findByPosition(Position thePosition);

}
