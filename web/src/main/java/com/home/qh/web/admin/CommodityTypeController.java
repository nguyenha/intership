package com.home.qh.web.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.qh.model.CommodityType;
import com.home.qh.service.CommodityTypeService;

@Controller
@RequestMapping("/admin")
public class CommodityTypeController extends BaseAdminController<CommodityType, CommodityTypeService> {
	@Autowired
	private CommodityTypeService commodityTypeService;

	@RequestMapping(value = "listCommodityType", method = RequestMethod.GET)
	public String getAll(Model model) {
		return super.listAllData(model, commodityTypeService);
	}
	
	@RequestMapping(value = "editCommodityType", method = RequestMethod.GET)
	public String edit(Model model, CommodityType editData) throws Exception {
		Long id = (editData != null && null != editData.getId()) ? editData.getId() : null;
		return super.editData(model, editData, id, commodityTypeService);
	}
	
	@RequestMapping(value = "editCommodityType", method = RequestMethod.POST)
	public String submit(@ModelAttribute("editData") @Valid CommodityType editData, BindingResult result, Model model) {
		return super.submit(editData, result, model, commodityTypeService);
	}

	@Override
  public String concreteView() {
	  return "admin/listCommodityType";
  }

  @Override
  public String concreteEdit() {
  	return "admin/editCommodityType";
  }
}
