package com.home.qh.jpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.qh.model.TransCtrType;

@Repository(value="transCtrTypeJPARepository")
public interface TransCtrTypeJPARepository extends JpaRepository<TransCtrType, Serializable> {

}
