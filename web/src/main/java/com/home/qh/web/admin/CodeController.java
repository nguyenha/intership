package com.home.qh.web.admin;

import java.beans.PropertyEditorSupport;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.qh.model.Code;
import com.home.qh.model.CodeType;
import com.home.qh.service.CodeService;
import com.home.qh.service.CodeTypeService;

@Controller
@RequestMapping("/admin")
public class CodeController extends BaseAdminController<Code, CodeService> {
	@Autowired
	private CodeTypeService codeTypeService;
	
	@Autowired
	private CodeService codeService;
	
	@RequestMapping(value = "listCode", method = RequestMethod.GET)
	public String getAll(Model model) {
		return super.listAllData(model, codeService);
	}
	
	@RequestMapping(value = "editCode", method = RequestMethod.GET)
	public String edit(Model model, Code editData) throws Exception {
		Long id = (editData != null && null != editData.getId()) ? editData.getId() : null;
		return super.editData(model, editData, id, codeService);
	}
	
	@RequestMapping(value = "editCode", method = RequestMethod.POST)
	public String submit(@ModelAttribute("editData") @Valid Code editData, BindingResult result, Model model) {
		return super.submit(editData, result, model, codeService);
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(CodeType.class, "codeType", new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				setValue(codeTypeService.get(Long.parseLong(text)));
			}
		}); // binder.setValidator(new FooValidator());
	}
	
	@ModelAttribute("codeTypes")
	public List<CodeType> getCodeTypes() {
		return codeTypeService.getAll();
	}
	 
	@Override
  public String concreteView() {
	  return "admin/listCode";
  }

  @Override
  public String concreteEdit() {
  	return "admin/editCode";
  }
}
