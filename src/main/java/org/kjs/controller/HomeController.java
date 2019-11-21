package org.kjs.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "redirect:/tobacco/list";
	}
	
	@GetMapping("/map/index")
	public String mapDefault() {
		return "map/index";
	}
	
	
	
	@GetMapping("/customLogin")
	public void loginInput(String error,String logout,Model model) {
		if(error!=null)
			model.addAttribute("error","Login Error Check Your Acount");
		
		if(logout!=null)
			model.addAttribute("logout", "LogOut!!");
	}
	
}
