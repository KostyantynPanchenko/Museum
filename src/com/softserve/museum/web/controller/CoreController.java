/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */

package com.softserve.museum.web.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.museum.domain.Author;
import com.softserve.museum.domain.Excursion;
import com.softserve.museum.domain.Exhibit;
import com.softserve.museum.domain.Guide;
import com.softserve.museum.service.ExcursionService;
import com.softserve.museum.service.ExhibitService;
import com.softserve.museum.service.GuideService;

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

	@Autowired
	private ExcursionService excursionService;

	@Autowired
	private ExhibitService exhibitService;

	@Autowired
	private GuideService guideService;

	@GetMapping("/")
	public ModelAndView onIndex() {
		testExhibits();
		testExcursions();
		testExhibitsByAuthor();
		testAuthors();
		testGuides2();
		ModelAndView model = new ModelAndView("index");
		return model;
	}

	@GetMapping("tours")
	public ModelAndView onTours() {
		ModelAndView model = new ModelAndView("excursions/excursions");
		List<Excursion> excursions = excursionService.listExcursions();
		model.addObject("excursions", excursions);
		return model;
	}

	@GetMapping("guides")
	public ModelAndView onGuides() {
		ModelAndView model = new ModelAndView("guides/guides");
		List<Guide> guides = guideService.listGuides();
		model.addObject("guides", guides);
		return model;
	}

	@GetMapping("exhibits")
	public ModelAndView onExhibits() {
		ModelAndView model = new ModelAndView("exhibits/exhibits");
		List<Exhibit> exhibits = exhibitService.listExhibits();
		model.addObject("exhibits", exhibits);
		return model;
	}

	private void testExhibits() {
		System.out.println(" ++++++++++++++++  EXHIBITS   ++++++++++++++++");
		List<Exhibit> exhibits = exhibitService.listExhibits();
		for (Exhibit ex : exhibits) {
			System.out.println(ex);
		}
		System.out.println(" ++++++++++++++++ END OF TEST ++++++++++++++++");
	}

	private void testExcursions() {
		System.out.println(" ++++++++++++++++  HIBERNATE  ++++++++++++++++");
		List<Excursion> exs = excursionService.listExcursions();
		for (Excursion ex : exs) {
			System.out.println(ex);
		}
		System.out.println(" ++++++++++++++++ END OF TEST ++++++++++++++++");
	}

	private void testExhibitsByAuthor() {
		System.out.println(" ++++++++++++++++  HIBERNATE  ++++++++++++++++");
		Author testAuthor = new Author();
		int authorId = 1010;
		testAuthor.setId(authorId);
		// Material testMaterial = new Material();
		// int authorId = 1006;
		// testMaterial.setId(new Integer(1006));
		System.out.println(" Set authorID" + testAuthor.getId());
		List<Exhibit> exhibits = exhibitService.findExhibitByAuthor(testAuthor);
		// List<Exhibit> exhibits =
		// exhibitService.findExhibitByMaterial(testMaterial);
		for (Exhibit ex : exhibits) {
			System.out.println(ex);
		}
		System.out.println(" ++++++++++++++++ END OF TEST ++++++++++++++++");
	}

	private void testAuthors() {
		System.out.println(" ++++++++++++++++  HIBERNATE  ++++++++++++++++");
		String start = "2016-12-25 12:00:00";
		String end = "2016-10-25 13:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		List<Guide> guides = guideService.findGuideByTime(LocalDateTime.parse(start, formatter),
				LocalDateTime.parse(end, formatter));
		for (Guide gd : guides) {
			System.out.println(gd);
		}
		System.out.println(" ++++++++++++++++ END OF TEST ++++++++++++++++");
	}

	@SuppressWarnings("rawtypes")
	private void testGuides2() {
		System.out.println(" ++++++++++++++++  HIBERNATE  ++++++++++++++++");
		String start = "2016-10-25 12:00:00";
		String end = "2016-12-25 13:00:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		List guides = guideService.getCountGuidesByPeriod(LocalDateTime.parse(start, formatter),
				LocalDateTime.parse(end, formatter));
		// for (Guide gd : guides) {
		System.out.println("Size = " + guides.size());
/*		for (int i = 0; i < guides.size(); i++) {
			System.out.println(guides.get(i).get + " " + guides.get(i) + " " + guides.get(i));

		}
*/		System.out.println(guides);
		// }
		System.out.println(" ++++++++++++++++ END OF TEST ++++++++++++++++");
	}
}
