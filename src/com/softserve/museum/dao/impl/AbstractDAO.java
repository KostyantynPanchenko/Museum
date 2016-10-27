/*
 * This is a simple web application utilizing Spring MVC and Hibernate.
 * Developed by Lv-205 group of Softserve Academy.
 * 
 * Copyright (c) 1993-2016 Softserve, Inc.
 * This software is the confidential and proprietary information of Softserve.
 * 
 */
package com.softserve.museum.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.softserve.museum.dao.generic.GenericDAO;

/**
 * 
 * Abstract class which provide default implementation of CRUD operations.
 * 
 * @author Kostyantyn Panchenko
 * @version 1.0
 * @since 23.10.2016
 *
 */
@Repository
@Transactional
public abstract class AbstractDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

    @Autowired
    protected SessionFactory sessionFactory;
    
    private Class<T> entityClass;
    
    protected AbstractDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public T findById(ID id) {
        return (T) sessionFactory.getCurrentSession().get(entityClass, id); 
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(entityClass);
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public ID save(T entity) {
        return (ID) sessionFactory.getCurrentSession().save(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public T update(T entity) {
        return (T) sessionFactory.getCurrentSession().merge(entity);
    }

    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

}
