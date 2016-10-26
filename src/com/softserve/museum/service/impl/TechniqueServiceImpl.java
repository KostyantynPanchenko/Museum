package com.softserve.museum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.museum.dao.generic.TechniqueDAO;
import com.softserve.museum.domain.Technique;
import com.softserve.museum.service.TechniqueService;

@Service
public class TechniqueServiceImpl implements TechniqueService {

    @Autowired
    private TechniqueDAO techniques;
    
    @Override
    public List<Technique> listTechniques() {       
        return techniques.getAll();
    }

}
