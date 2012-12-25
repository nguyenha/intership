package com.home.qh.web.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.qh.model.CodeType;
import com.home.qh.service.CodeTypeService;

@Controller
@RequestMapping("/admin")
public class CodeTypeController extends BaseAdminController<CodeType, CodeTypeService> {
	@Autowired
	private CodeTypeService codeTypeService;

	@RequestMapping(value = "listCodeType", method = RequestMethod.GET)
	public String getAll(Model model) {
		return super.listAllData(model, codeTypeService);
	}
	
	@RequestMapping(value = "editCodeType", method = RequestMethod.GET)
	public String edit(Model model, CodeType editData) throws Exception {
		Long id = (editData != null && null != editData.getId()) ? editData.getId() : null;
		return super.editData(model, editData, id, codeTypeService);
	}
	
	@RequestMapping(value = "editCodeType", method = RequestMethod.POST)
	public String submit(@ModelAttribute("editData") @Valid CodeType editData, BindingResult result, Model model) {
		return super.submit(editData, result, model, codeTypeService);
	}

	@Override
  public String concreteView() {
	  return "admin/listCodeType";
  }

  @Override
  public String concreteEdit() {
  	return "admin/editCodeType";
  }
}
