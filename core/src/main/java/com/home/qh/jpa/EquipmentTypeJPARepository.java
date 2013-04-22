package com.home.qh.jpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.qh.model.EquipmentType;

@Repository(value="equipmentTypeJPARepository")
public interface EquipmentTypeJPARepository extends JpaRepository<EquipmentType, Serializable> {

}
