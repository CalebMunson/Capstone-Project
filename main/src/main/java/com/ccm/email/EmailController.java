package com.ccm.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ccm.user.UserController;

@Controller
public class EmailController {
	
	@Autowired
	private EmailSenderService senderService;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	
	String message;
	
	UserController user;
	
	@GetMapping(value="/register")
	public String register(@RequestParam(name="username", required = true) String username, 
						   @RequestParam(name="password", required = true) String password,
						   @RequestParam(name="firstName", required = true) String firstName,
						   @RequestParam(name="lastName", required = true) String lastName,
						   @RequestParam(name="email", required = true) String email) {
		
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		
		message = "Hello " + this.firstName + " " + this.lastName + ",\n\n"
				+ "You registered an account with the following information: \n\n"
				+ "Username: " + this.username + "\n"
				+ "Name: " + this.firstName + " " + this.lastName + "\n"
				+ "Email: " + this.email + "\n"
				+ "Password: " + this.password;
		
		senderService.sendEmail(this.email, "Registration", message);
		
		return "login";
	}
	
	@PostMapping(value="/login")
	public String login(@RequestParam(name="username", required = false) String username, @RequestParam(name="password", required = false) String password) {
		this.username = username;
		this.password = password;
		return "landing";
	}
}
