package com.smart.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.dao.UserRepository;
import com.smart.entity.Contact;
import com.smart.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	//method for adding common data to response
	@ModelAttribute
	public void addCommonData(Model model, Principal principal) {
		String userName=principal.getName();
		System.out.println("USERNAME: "+userName);
		
		User user=userRepository.getUserByUserName(userName);
		System.out.println("USER "+user);
		model.addAttribute("user",user);
		
	}
	
	//Dashboard Home
	@RequestMapping("/index")
	public String dashboard(Model model, Principal principal) {
		String userName=principal.getName();
		System.out.println("USERNAME: "+userName);
		
		User user=userRepository.getUserByUserName(userName);
		System.out.println("USER "+user);
		model.addAttribute("user",user);
		model.addAttribute("title","User Dashboard - Smart Contact Manager");
		return "normal/user_dashboard";
	}
	
	//open add form handler
	@GetMapping("/add-contact")
	public String openAddContactForm(Model model) {
		model.addAttribute("title","Add Contact - Smart Contact Manager");
		model.addAttribute("contact",new Contact());
		return "normal/add_contact_form";
	}

}
