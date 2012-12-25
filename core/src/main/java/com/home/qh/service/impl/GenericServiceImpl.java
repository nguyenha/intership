package com.home.qh.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.home.qh.service.GenericService;


/**
 * Generic service implementation.
 * @author Quynh Nguyen
 * @since 1.0
 * @param <T>
 * @param <PK>
 */
//@Service
public class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {
	/**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());

    /**
     * GenericDao instance, set by constructor of child classes.
     */
    //@Autowired
    protected JpaRepository<T, PK> jpa;

    /**
     * Default constructor.
     */
    public GenericServiceImpl() { }

    /**
     * Customized constructor.
     * @param genericJPA
     * 			the parameter
     */
    public GenericServiceImpl(JpaRepository<T, PK> genericJPA) {
        this.jpa = genericJPA;
    }

	@Override
	public List<T> getAll() {
		return jpa.findAll();
	}

	@Override
	public T get(PK id) {
		return jpa.findOne(id);
	}

	@Override
	public boolean exists(PK id) {
		return jpa.exists(id);
	}

	@Override
	public T save(T object) {
		return jpa.save(object);
	}

	@Override
	public void remove(PK id) {
		jpa.delete(id);
	}

}