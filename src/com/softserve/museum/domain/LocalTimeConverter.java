/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.domain;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 
 * Utility class which converts LocalDateTime to Timestamp representation.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 21.10.2016 
 *
 */
@Converter
public class LocalTimeConverter
        implements AttributeConverter<LocalTime, Time> {

    @Override
    public Time convertToDatabaseColumn(LocalTime attribute) {       
        return ((attribute == null) ? null : Time.valueOf(attribute));
    }

    @Override
    public LocalTime convertToEntityAttribute(Time dbData) {
        return ((dbData == null) ? null : dbData.toLocalTime());
    }

}
