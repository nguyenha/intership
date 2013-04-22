package com.home.qh.web.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.qh.model.EquipmentType;
import com.home.qh.service.EquipmentTypeService;

@Controller
@RequestMapping("/admin")
public class EquipmentTypeController extends BaseAdminController<EquipmentType, EquipmentTypeService> {
	@Autowired
	private EquipmentTypeService equipmentTypeService;

	@RequestMapping(value = "listEquipmentType", method = RequestMethod.GET)
	public String getAll(Model model) {
		return super.listAllData(model, equipmentTypeService);
	}
	
	@RequestMapping(value = "editEquipmentType", method = RequestMethod.GET)
	public String edit(Model model, EquipmentType editData) throws Exception {
		Long id = (editData != null && null != editData.getId()) ? editData.getId() : null;
		return super.editData(model, editData, id, equipmentTypeService);
	}
	
	@RequestMapping(value = "editEquipmentType", method = RequestMethod.POST)
	public String submit(@ModelAttribute("editData") @Valid EquipmentType editData, BindingResult result, Model model) {
		return super.submit(editData, result, model, equipmentTypeService);
	}

	@Override
  public String concreteView() {
	  return "admin/listEquipmentType";
  }

  @Override
  public String concreteEdit() {
  	return "admin/editEquipmentType";
  }
}
