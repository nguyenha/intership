package com.home.qh.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.qh.jpa.TransCtrTypeJPARepository;
import com.home.qh.model.TransCtrType;
import com.home.qh.service.TransCtrTypeService;

@Service
public class TransCtrTypeServiceImpl extends GenericServiceImpl<TransCtrType, Serializable> implements
TransCtrTypeService {
	@Autowired
	private TransCtrTypeJPARepository repo;

    @Autowired
    public TransCtrTypeServiceImpl(TransCtrTypeJPARepository transCtrTypeJPA) {
        super(transCtrTypeJPA);
        this.repo = transCtrTypeJPA;
    }
}
