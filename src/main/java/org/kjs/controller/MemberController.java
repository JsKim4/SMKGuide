package org.kjs.controller;

import javax.servlet.http.HttpServletRequest;

import org.kjs.domain.CustomUser;
import org.kjs.domain.MemberVO;
import org.kjs.service.CommentService;
import org.kjs.service.MemberService;
import org.kjs.service.SmokelogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
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
	SmokelogService logService;
	CommentService commentService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);


	@GetMapping("/loginForm")
	public void login(String error,String logout,Model model,HttpServletRequest request) {
		 String referrer = request.getHeader("Referer");
		 request.getSession().setAttribute("prevPage", referrer);
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
	
	@Secured({"ROLE_USER"})
	@GetMapping("/mypage")
	public void mypage(Model model) {
		CustomUser member= (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("member",member.getVo());
	}
}
