package com.softserve.museum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.museum.dao.generic.MaterialDAO;
import com.softserve.museum.domain.Material;
import com.softserve.museum.service.MaterialService;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialDAO materials;
    
    @Override
    public List<Material> listMaterials() {
        return materials.getAll();
    }

    @Override
    public List<Material> findMaterialByName(String m) {
        return materials.findMaterialByName(m);
    }

}
