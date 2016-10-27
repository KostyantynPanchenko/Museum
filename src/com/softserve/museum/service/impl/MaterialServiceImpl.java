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
    
    /**
     * Finds all materials
     * @return <code>List&lt;Material&gt;</code>of all materials
     */
    @Override
    public List<Material> listMaterials() {
        return materials.getAll();
    }

    /**
     * Finds all materials
     * @param m given material name
     * @return <code>List&lt;Material&gt;</code>of all materials by given nam
     */
    @Override
    public List<Material> findMaterialByName(String m) {
        return materials.findMaterialByName(m);
    }

}
