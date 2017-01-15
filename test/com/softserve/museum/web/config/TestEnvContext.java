package com.softserve.museum.web.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.softserve.museum.service.ExcursionService;
import com.softserve.museum.service.ExhibitService;
import com.softserve.museum.service.GuideService;
import com.softserve.museum.service.MaterialService;
import com.softserve.museum.service.TechniqueService;

@Configuration
public class TestEnvContext {

    @Bean
    ExcursionService excursionService() {
        return Mockito.mock(ExcursionService.class);
    }    
    
    @Bean
    ExhibitService exhibitService() {
        return Mockito.mock(ExhibitService.class);
    }

    @Bean
    GuideService guideService() {
        return Mockito.mock(GuideService.class);
    }
    

    @Bean
    MaterialService materialService() {
        return Mockito.mock(MaterialService.class);
    }
    

    @Bean
    TechniqueService techiqueService() {
        return Mockito.mock(TechniqueService.class);
    }
}
