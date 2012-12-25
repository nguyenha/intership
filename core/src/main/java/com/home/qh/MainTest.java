package com.home.qh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.home.qh.config.CoreConfig;
import com.home.qh.model.CodeType;
import com.home.qh.service.CodeTypeService;
import com.home.qh.service.impl.CodeTypeServiceImpl;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Here it is");
		ApplicationContext ctx = new AnnotationConfigApplicationContext(CoreConfig.class);
		
		CodeTypeService codeTypeImpl = ctx.getBean(CodeTypeServiceImpl.class);
		
		CodeType codeType = new CodeType("code", "name");
		System.out.println("Come here: " + codeTypeImpl.save(codeType));
		
		System.out.println("List: " + codeTypeImpl.getAll().size());
	}

}
