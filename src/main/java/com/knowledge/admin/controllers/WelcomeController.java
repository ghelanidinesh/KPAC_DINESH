package com.knowledge.admin.controllers;

import com.knowledge.admin.constants.KnowledgePackageConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class WelcomeController {

	@RequestMapping(value = KnowledgePackageConstant.RIGHT_SLASH)
	public String home() {
		log.info(KnowledgePackageConstant.ApiConstant.HELLO_SPRING_MVC);
		return KnowledgePackageConstant.ApiConstant.WELCOME;
	}
}
