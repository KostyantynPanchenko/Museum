package com.softserve.museum.service;

import java.util.List;

import com.softserve.museum.domain.Material;

public interface MaterialService {

    public abstract List<Material> listMaterials();

    public abstract List<Material> findMaterialByName(String m);

}
