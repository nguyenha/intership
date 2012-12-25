package com.home.qh;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.home.qh.config.RootConfig;
import com.home.qh.model.CodeType;
import com.home.qh.service.CodeTypeService;
import com.home.qh.service.impl.CodeTypeServiceImpl;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Here it is");
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(RootConfig.class);
//		
//		CodeTypeService codeTypeImpl = ctx.getBean(CodeTypeServiceImpl.class);
//		
//		CodeType codeType = new CodeType("code", "name");

		try {
	    System.out.println("Encode: " + URLEncoder.encode("all_roles@esoftsystems.com", "utf8"));
    } catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
    }
	}

}
