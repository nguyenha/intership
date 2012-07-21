package com.home.qh.web.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sun.java2d.pipe.SpanShapeRenderer.Simple;

import com.home.qh.model.CodeType;
import com.home.qh.service.CodeTypeService;

@Controller
@RequestMapping("/admin")
public class CodeTypeController {
	@Autowired
	private CodeTypeService codeTypeService;

	@RequestMapping(value = "listCodeType", method = RequestMethod.GET)
	public String listCodeType(Model model) {
		List<CodeType> codeTypeList = codeTypeService.getAll();
		model.addAttribute("codeTypeList", codeTypeList);
		return "admin/listCodeType";
	}
	
	@RequestMapping(value = "editCodeType", method = {RequestMethod.GET, RequestMethod.POST})
	public String addCodeType(@Validated({ Simple.class }) Model model, CodeType codeType) {
		if (codeType != null && codeType.getCode() != null) {
			codeTypeService.save(codeType);
			return "redirect:/admin/listCodeType";
		} else if (codeType != null && codeType.getId() != null && codeType.getId().longValue() > 0) {
			model.addAttribute("codeType", codeTypeService.get(codeType.getId()));
		}
		return "admin/editCodeType";
	}
}
