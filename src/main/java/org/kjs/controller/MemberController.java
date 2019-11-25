package org.kjs.controller;

import org.kjs.domain.MemberVO;
import org.kjs.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
	
	
	@GetMapping("/register")
	public void registerForm() {
		logger.debug("NOSET");
	}
	@PostMapping("/register")
	public String register(MemberVO vo) {
		logger.info(vo.toString());
		service.join(vo);
		return "redirect:/";
	}
}
