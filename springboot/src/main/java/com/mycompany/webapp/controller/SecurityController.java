package com.mycompany.webapp.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.security.CustomUserDetails;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/security")
public class SecurityController {
	
	@RequestMapping("/content")
	public String content(Authentication authentication) {
		log.info("Run");
		
		if(authentication != null && authentication.isAuthenticated()) {
//			log.info(authentication.getPrincipal().toString());
			CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
			log.info(customUserDetails.getUsername());
			log.info(customUserDetails.getUseremail());
		}
		
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
	
	@RequestMapping("/admin/action")
	public String adminAction() {
		log.info("Run");
		
		return "redirect:/security/content";
	}
	   
	@RequestMapping("/manager/action")
	public String managerAction() {
		log.info("Run");
		
		return "redirect:/security/content";
	}
   
	@RequestMapping("/user/action")
	public String userAction() {
		log.info("Run");
		
		return "redirect:/security/content";
	}
	
}
