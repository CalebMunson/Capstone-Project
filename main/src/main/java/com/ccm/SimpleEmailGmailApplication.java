package com.ccm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.ccm.email.EmailSenderService;

@SpringBootApplication
public class SimpleEmailGmailApplication {
	@Autowired
	private EmailSenderService senderService;
	
	public static void main(String[] args) {
		SpringApplication.run(SimpleEmailGmailApplication.class, args);
	}
}
