package com.home.qh.web.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.qh.model.TransCtrType;
import com.home.qh.service.TransCtrTypeService;

@Controller
@RequestMapping("/admin")
public class TransCtrTypeController extends BaseAdminController<TransCtrType, TransCtrTypeService> {
	@Autowired
	private TransCtrTypeService transCtrTypeService;

	@RequestMapping(value = "listTransCtrType", method = RequestMethod.GET)
	public String getAll(Model model) {
		return super.listAllData(model, transCtrTypeService);
	}
	
	@RequestMapping(value = "editTransCtrType", method = RequestMethod.GET)
	public String edit(Model model, TransCtrType editData) throws Exception {
		Long id = (editData != null && null != editData.getId()) ? editData.getId() : null;
		return super.editData(model, editData, id, transCtrTypeService);
	}
	
	@RequestMapping(value = "editTransCtrType", method = RequestMethod.POST)
	public String submit(@ModelAttribute("editData") @Valid TransCtrType editData, BindingResult result, Model model) {
		return super.submit(editData, result, model, transCtrTypeService);
	}

	@Override
  public String concreteView() {
	  return "admin/listTransCtrType";
  }

  @Override
  public String concreteEdit() {
  	return "admin/editTransCtrType";
  }
}
