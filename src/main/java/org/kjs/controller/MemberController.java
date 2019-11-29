package org.kjs.controller;

import org.kjs.domain.MemberVO;
import org.kjs.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;

@RequestMapping("/member")
@AllArgsConstructor
@Controller
public class MemberController {

	MemberService service;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


	@GetMapping("/loginForm")
	public void login(String error,String logout,Model model) {
		if(error!=null)
			model.addAttribute("error","Login Error Check Your Account");
		if(logout!=null)
			model.addAttribute("logout","Logout!");
	}
	@PostMapping("/login")
	public void loginPost(String error,String logout,Model model) {
		if(error!=null)
			model.addAttribute("error","Login Error Check Your Account");
		if(logout!=null)
			model.addAttribute("logout","Logout!");
	}

	@GetMapping("/register")
	public void registerForm() {
		logger.debug("NOSET");
	}
	@PostMapping("/register")
	public String register(MemberVO vo) {
		service.join(vo);
		return "redirect:/";
	}
	
	@PostMapping("/logout")
	public String logout() {
		logger.info("logout");
		return "redirect:/";
	}
}
