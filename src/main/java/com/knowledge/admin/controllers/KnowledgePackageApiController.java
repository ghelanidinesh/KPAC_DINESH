package com.knowledge.admin.controllers;

import com.knowledge.admin.constants.KnowledgePackageConstant;
import com.knowledge.admin.dto.KnowledgePackageDTO;
import com.knowledge.admin.dto.KnowledgePackageSetDTO;
import com.knowledge.admin.entity.KnowledgePackage;
import com.knowledge.admin.services.KpacService;
import com.knowledge.admin.services.KpacSetService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
@RequestMapping(KnowledgePackageConstant.ApiConstant.RIGHT_SLASH_API)
public class KnowledgePackageApiController {
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

	@ResponseBody
	@GetMapping(value = KnowledgePackageConstant.ApiConstant.KPACS_URL_API, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<KnowledgePackageDTO> getKpacs() {
		final List<KnowledgePackageDTO> knowledgePackageDTOs = kpacService.getAllKpacs();
		return knowledgePackageDTOs;
	}

	@ResponseBody
	@DeleteMapping(value = KnowledgePackageConstant.ApiConstant.KPACS_ID_URL_API)
	public void deleteKpac(@PathVariable int id) {
		kpacService.deleteKpac(id);
	}

	@ResponseBody
	@GetMapping(value = KnowledgePackageConstant.ApiConstant.SETS_URL_API, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<KnowledgePackageSetDTO> getKpacSets() {
		return kpacSetService.getAllKpacSet();
	}

	@ResponseBody
	@DeleteMapping(value =KnowledgePackageConstant.ApiConstant.SETS_ID_URL_API)
	public void deleteKpacSet(@PathVariable int id) {
		kpacSetService.deleteKpacSet(id);
	}

	@ResponseBody
	@GetMapping(value = KnowledgePackageConstant.ApiConstant.KPACS_SETS_ID_URL_API, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<KnowledgePackageDTO> getKpacsFromSet(@PathVariable int setId) {
		return kpacService.getKpacsBySetId(setId);
	}
}
