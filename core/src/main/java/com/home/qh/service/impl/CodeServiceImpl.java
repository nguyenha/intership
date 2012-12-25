package com.home.qh.service.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.qh.jpa.CodeJPARepository;
import com.home.qh.model.Code;
import com.home.qh.service.CodeService;

@Service
public class CodeServiceImpl extends GenericServiceImpl<Code, Serializable> implements
		CodeService {
	@Autowired
	private CodeJPARepository repo;

    @Autowired
    public CodeServiceImpl(CodeJPARepository codeJPA) {
        super(codeJPA);
        this.repo = codeJPA;
    }
}
