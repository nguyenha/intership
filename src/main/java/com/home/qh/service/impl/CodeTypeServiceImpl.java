package com.home.qh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.qh.jpa.CodeTypeJPARepository;
import com.home.qh.model.CodeType;
import com.home.qh.service.CodeTypeService;

@Service
public class CodeTypeServiceImpl extends GenericServiceImpl<CodeType, Long> implements
		CodeTypeService {
	@Autowired
	private CodeTypeJPARepository repo;

    @Autowired
    public CodeTypeServiceImpl(CodeTypeJPARepository codeTypeJPA) {
        super(codeTypeJPA);
        this.repo = codeTypeJPA;
    }
}
