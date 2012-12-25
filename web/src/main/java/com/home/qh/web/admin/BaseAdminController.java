/**
 * 
 * @(#)BaseController.java
 *
 * Copyright 2012 by esoft systems (tm).
 * All rights reserved.
 */
 
package com.home.qh.web.admin;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.home.qh.service.GenericService;

/**
 * @author quynh.nn
 * @since 1.0 Dec 13, 2012
 *
 */
@Configurable
public abstract class BaseAdminController<T, R extends GenericService<T, Serializable>> {
	@Autowired
	private MessageSource messageResource;
	

	protected String listAllData(Model model, R service) {
		List<T> allDataValues = service.getAll();
		model.addAttribute("listData", allDataValues);
		return concreteView();
	}
	
  @SuppressWarnings("unchecked")
  protected String editData(Model model, T editData, Long id, R service) throws Exception {
		if (null != id) {
			model.addAttribute("editData", service.get(id));
		} else {
			editData = ((Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
	     model.addAttribute("editData", editData);
		}
		return concreteEdit();
	}

	public String submit(T editData, BindingResult result, Model model, R service) {
		if (result.hasErrors()) {
			return concreteEdit();
		} else {
			try {
				service.save(editData);
				return "redirect:/" + concreteView();
			} catch (Exception e) {
				result.addError(new ObjectError("objName", messageResource
				    .getMessage("errors.constraint", null, Locale.ENGLISH)));
				return concreteEdit();
			}
		}
	}

	public abstract String concreteView();
	public abstract String concreteEdit();
}
