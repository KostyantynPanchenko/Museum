/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */

/**
 * 
 * Proxy class, represents museum's guide statistic results.
 * 
 * @author Yuri Pushchalo
 * @version 1.0
 * @since 27.10.2016
 *
 */
package com.softserve.museum.domain;

import java.time.LocalTime;

public class GuideStatisticDTO {

	private String firstName;

	private String lastName;
	
	private long totalExcursions;
	
	private LocalTime excursionsTotalDuration;

	/**
	 * Default no-args constructor
	 */
	public GuideStatisticDTO() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getTotalExcursions() {
		return totalExcursions;
	}

	public void setTotalExcursions(long totalExcursions) {
		this.totalExcursions = totalExcursions;
	}

	public LocalTime getExcursionsTotalDuration() {
		return excursionsTotalDuration;
	}

	public void setExcursionsTotalDuration(LocalTime excursionsTotalDuration) {
		this.excursionsTotalDuration = excursionsTotalDuration;
	}
	
	@Override
	public String toString() {
		return "Guide [First Name=" + firstName + ", " + 
				"Last Name=" + lastName + ", " + "Total Excursions Number=" + totalExcursions + 
				"Excursion Total Duration=" + excursionsTotalDuration + "]";
	}
	}
