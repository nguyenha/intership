package com.home.qh.jpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.qh.model.CommodityType;

@Repository(value="commodityTypeJPARepository")
public interface CommodityTypeJPARepository extends JpaRepository<CommodityType, Serializable> {

}
