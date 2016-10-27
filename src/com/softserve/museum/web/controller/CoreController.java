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

    /**
     * Handles request to welcome page
     * @return logical view name
     */
	@GetMapping("/")
	public String onIndex() {
		return "index";
	}

}
