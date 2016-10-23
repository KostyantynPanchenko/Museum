/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.generic;

import java.util.List;

/**
 * 
 * Generic DAO interface.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 22.10.2016
 *
 */
public interface GenericDAO<T, ID> {

    /**
     * Finds object by its id.
     * @param id object's id
     * @return instance of type T
     */
    public abstract T findById(ID id);
    
    /**
     * @return all instances of given type T.
     */
    public abstract List<T> getAll();
    
    /**
     * Persists given entity of type T.
     * @param entity instance of type T to be persisted.
     * @return ID of persisted entity.
     */
    public abstract ID save(T entity);
    
    /**sates given instance of type T.
     * @param entity instance to be updated.
     * @return persisted entity.
     */
    public abstract T update(T entity);
    
    /**
     * Deletes given entity of type T.
     * @param entity to be deleted.
     */
    public abstract void delete(T entity);
}
