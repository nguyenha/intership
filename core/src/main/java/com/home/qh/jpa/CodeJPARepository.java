package com.home.qh.jpa;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.qh.model.Code;

@Repository(value="codeJPARepository")
public interface CodeJPARepository extends JpaRepository<Code, Serializable> {

}
