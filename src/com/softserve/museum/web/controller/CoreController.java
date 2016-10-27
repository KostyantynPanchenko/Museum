/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */

package com.softserve.museum.web.controller;

/*import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
import com.softserve.museum.domain.Exhibit;
import com.softserve.museum.domain.GuideStatisticDTO;
import com.softserve.museum.service.ExhibitService;
import com.softserve.museum.service.GuideService;
*/

/**
 * 
 * Core servlet controller class.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 22.10.2016
 *
 */
@Controller
public class CoreController {

/*	@Autowired
	private GuideService guideService;
	@Autowired
	private ExhibitService exhibitService;
*/
	@GetMapping("/")
	public String onIndex() {
/*		testExhibits();
		testStatistic();
*/
		return "index";
	}

	/*
	 * private void testExhibits() { System.out.println(
	 * " ++++++++++++++++  EXHIBITS   ++++++++++++++++"); List<Exhibit> exhibits
	 * = exhibitService.listExhibits(); for (Exhibit ex: exhibits) {
	 * System.out.println(ex); } System.out.println(
	 * " ++++++++++++++++ END OF TEST ++++++++++++++++"); }
	 * 
	 * private void testStatistic() { System.out.println(
	 * " ++++++++++++++++  HIBERNATE  ++++++++++++++++");
	 * 
	 * String str = "2016-10-25 10:00:00"; DateTimeFormatter formatter =
	 * DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); LocalDateTime start =
	 * LocalDateTime.parse(str, formatter); str = "2016-12-25 14:00:00";
	 * LocalDateTime end = LocalDateTime.parse(str, formatter);
	 * System.out.println(start); System.out.println(end);
	 * 
	 * List<GuideStatisticDTO> guides =
	 * guideService.getGuidesStatisticByPeriod(start, end); for
	 * (GuideStatisticDTO gdto : guides) { System.out.println(gdto); }
	 * System.out.println(" ++++++++++++++++ END OF TEST ++++++++++++++++"); }
	 */
}
