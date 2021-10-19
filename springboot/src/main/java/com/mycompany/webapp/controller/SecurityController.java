package com.mycompany.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/security")
public class SecurityController {
	
	@RequestMapping("/content")
	public String content() {
		log.info("Run");
		
		return "security/content";
	}

	@RequestMapping("/loginForm")
	public String loginForm() {
		log.info("Run");
		
		return "security/loginForm";
	}
	
	@RequestMapping("/loginError")
	public String loginError(Model model) {
		log.info("Run");
		
		model.addAttribute("loginError", true);
		
		return "security/loginForm";
	}
	
	@RequestMapping("/accessDenied")
	public String accessDenied() {
		log.info("Run");
		
		return "security/accessDenied";
	}
	
}
