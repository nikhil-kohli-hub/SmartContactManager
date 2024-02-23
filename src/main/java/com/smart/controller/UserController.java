package com.smart.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/index")
	public String dashboard(Model model, Principal principal) {
		String userName=principal.getName();
		System.out.println("USERNAME: "+userName);
		return "normal/user_dashboard";
	}

}
