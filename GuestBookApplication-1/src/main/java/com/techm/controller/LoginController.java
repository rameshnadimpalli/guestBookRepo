package com.techm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techm.bean.Entry;
import com.techm.bean.Login;
import com.techm.service.LoginService;
/**
 * 
 * @author Ramesh Nadimpalli
 * @date 10-May-2019
 */
@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/createEntry", method = RequestMethod.POST)
	public String showForm(@ModelAttribute("login") Login login, Model m) {
		String isValid = loginService.validate(login.getUsername(), login.getPassword());
		if (isValid.equalsIgnoreCase("G"))
			return "createEntry";
		if (isValid.equalsIgnoreCase("A"))
			return "redirect:/showGuestbook";
		else {
			m.addAttribute("DNE", "User Does not Exist Try Again");
			return "guestSignin";
		}
	}

	@RequestMapping("/index")
	public String index(Model m) {
		return "index.jsp";
	}
	
	@RequestMapping("/guestSignin")
	public String guestLogin(Model m) {
		m.addAttribute("command", new Entry());
		return "guestSignin";
	}

	@RequestMapping("/adminSignin")
	public String adminLogin(Model m) {
		m.addAttribute("command", new Entry());
		return "adminSignin";
	}
}