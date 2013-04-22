package com.home.qh.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.qh.jpa.CommodityTypeJPARepository;
import com.home.qh.model.CommodityType;
import com.home.qh.service.CommodityTypeService;

@Service
public class CommodityTypeServiceImpl extends GenericServiceImpl<CommodityType, Serializable> implements
CommodityTypeService {
	@Autowired
	private CommodityTypeJPARepository repo;

    @Autowired
    public CommodityTypeServiceImpl(CommodityTypeJPARepository commodityTypeJPA) {
        super(commodityTypeJPA);
        this.repo = commodityTypeJPA;
    }
}
