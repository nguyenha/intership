package com.home.qh.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.home.qh.model.CodeType;

@Repository(value="codeTypeJPARepository")
public interface CodeTypeJPARepository extends JpaRepository<CodeType, Long> {

}
