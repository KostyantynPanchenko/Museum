package com.softserve.museum.web.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.softserve.museum.domain.Excursion;
import com.softserve.museum.service.ExcursionService;
import com.softserve.museum.web.config.TestEnvContext;
import com.softserve.museum.web.config.WebAppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestEnvContext.class, WebAppConfig.class })
@WebAppConfiguration
public class ExcursionsControllerTest {

    private MockMvc mockMvc;
    
    @Autowired
    private ExcursionService excursionServiceMock;
    
    @Autowired
    private WebApplicationContext webAppConfig;
    
    @Before
    public void setUp() {
        this.excursionServiceMock = Mockito.mock(ExcursionService.class);        
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppConfig).build();
    }
    
    @Test
    public void allMethodShouldAddEntriesToModelAndRenderView() throws Exception {       
        LocalDateTime start = LocalDateTime.now();
        
        Excursion first = new Excursion();
        first.setId(0);
        first.setStart(start);
        first.setEnd(start.plusHours(2));
        
        Excursion second = new Excursion();
        second.setId(1);
        second.setStart(start.plusHours(1));
        second.setEnd(start.plusHours(3));
        
        when(excursionServiceMock.listSchedule()).thenReturn(Arrays.asList(first, second));
        excursionServiceMock.listSchedule();
        
        mockMvc.perform(get("/tours/all"))
                .andExpect(status().isOk())
                .andExpect(view().name("excursions/excursionsAll"))
                .andExpect(forwardedUrl("/WEB-INF/views/excursions/excursionsAll.jsp"))
                .andExpect(model().attributeExists("excursions"));
//                .andExpect(model().attribute("excursions", hasSize(2)))
//                .andExpect(model().attribute("excursions", hasItem(
//                        allOf(
//                                hasProperty("id", is(0)),
//                                hasProperty("start", is(start)),
//                                hasProperty("end", is(start.plusHours(2)))
//                        )
//                 )))
//                .andExpect(model().attribute("excursions", hasItem(
//                        allOf(
//                                hasProperty("id", is(1)),
//                                hasProperty("start", is(start.plusHours(1))),
//                                hasProperty("end", is(start.plusHours(3)))
//                        )
//                 )));
        verify(excursionServiceMock, times(1)).listSchedule();
        verifyNoMoreInteractions(excursionServiceMock);
    }
    
    @Test
    public void showTimeSlotFormMethodShouldAddEntriesToModelAndRenderView() throws Exception {        
        mockMvc.perform(get("/tours/timeslot"))
                .andExpect(status().isOk())
                .andExpect(view().name("excursions/excursionsInSlot"))
                .andExpect(forwardedUrl("/WEB-INF/views/excursions/excursionsInSlot.jsp"))
                .andExpect(model().attributeExists("start"))
                .andExpect(model().attributeExists("end"));
    }
    
    @Test
    public void processTimeSlotSearchForm() {
        //TODO
    }
    
}
