package com.ccm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SimpleEmailGmailApplication {
	@Autowired
	private EmailSenderService senderService;
	
	public static void main(String[] args) {
		SpringApplication.run(SimpleEmailGmailApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() {
		senderService.sendEmail("couchdroids@gmail.com", 
				"This is Subject",
				"This is Body of email");
	}
}
