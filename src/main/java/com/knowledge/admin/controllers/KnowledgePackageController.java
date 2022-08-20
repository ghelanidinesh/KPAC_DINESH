package com.knowledge.admin.controllers;

import com.knowledge.admin.constants.KnowledgePackageConstant;
import com.knowledge.admin.entity.KnowledgePackage;
import com.knowledge.admin.entity.KnowledgePackageSet;
import com.knowledge.admin.services.KpacService;
import com.knowledge.admin.services.KpacSetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping
public class KnowledgePackageController {
	private KpacService kpacService;

	private KpacSetService kpacSetService;

	@Autowired
	public void setKpacService(KpacService kpacService) {
		this.kpacService = kpacService;
	}

	@Autowired
	public void setKpacSetService(KpacSetService kpacSetService) {
		this.kpacSetService = kpacSetService;
	}

	@GetMapping(value = KnowledgePackageConstant.ApiConstant.KPACS_URL_API)
	public String getKpacs() {
		return "knowledge_packages";
	}
	@PostMapping(value = KnowledgePackageConstant.ApiConstant.KPACS_URL_API)
	public String addKpac(@ModelAttribute("knowledgePackage") KnowledgePackage knowledgePackage) {
		kpacService.saveKpac(knowledgePackage);
		return KnowledgePackageConstant.ApiConstant.REDIRECT_KPACS_ID_API;
	}
	@GetMapping(value= KnowledgePackageConstant.ApiConstant.SETS_URL_API)
	public String getKpacSets(Model model) {
		return KnowledgePackageConstant.ApiConstant.KPACS_SETS_PAGE;
	}
	@PostMapping(value = KnowledgePackageConstant.ApiConstant.SETS_URL_API)
	public String addKpacSet(@ModelAttribute("knowledgePackageSet") KnowledgePackageSet knowledgePackageSet) {
		kpacSetService.saveKpacSet(knowledgePackageSet);
		return KnowledgePackageConstant.ApiConstant.REDIRECT_SET_URL_API;
	}
	@GetMapping(value = KnowledgePackageConstant.ApiConstant.SET_KPI_ID_URL_API)
	public String getKpacsFromSet(Model model, @PathVariable int kpacSetId) {
		model.addAttribute("kpacSetId", kpacSetId);
		return "knowledge_package_by_set";
	}
}
