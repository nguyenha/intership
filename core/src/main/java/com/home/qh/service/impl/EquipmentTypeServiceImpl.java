package com.home.qh.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.qh.jpa.EquipmentTypeJPARepository;
import com.home.qh.model.EquipmentType;
import com.home.qh.service.EquipmentTypeService;

@Service
public class EquipmentTypeServiceImpl extends GenericServiceImpl<EquipmentType, Serializable> implements
EquipmentTypeService {
	@Autowired
	private EquipmentTypeJPARepository repo;

    @Autowired
    public EquipmentTypeServiceImpl(EquipmentTypeJPARepository equipmentTypeJPA) {
        super(equipmentTypeJPA);
        this.repo = equipmentTypeJPA;
    }
}
