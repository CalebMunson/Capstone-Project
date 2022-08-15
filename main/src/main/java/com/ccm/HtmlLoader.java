package com.ccm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HtmlLoader {

	@Autowired
	private EmailSenderService senderService;
	private String username;
	private String password;
	
//	@GetMapping("/login")
//	public String greeting(@RequestParam(name="name", required = false, defaultValue="World") String name, Model model) {
//		model.addAttribute("name", name);
//		return "login";
//	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@PostMapping(value="/login")
	public String login(@RequestParam(name="username", required = false) String userName, @RequestParam(name="password", required = false) String password, Model model) {
		model.addAttribute("username", userName);
		model.addAttribute("password", password);
		System.out.println(userName + ", " + password);
		this.password = password;
		this.username = userName;
		return "email";
	}
	
	@PostMapping(value="/email")
	public String email() {
		System.out.println("Email sent...");
		senderService.sendEmail(username, password, username);
		return "email";
	}
	
//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	}
	
}
