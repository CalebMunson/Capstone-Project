// SubscribeController.java
package com.email.subscribe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class SubscribeController implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/subscribe/confirmation").setViewName("subscribe/confirmation");
	}

	@GetMapping("/")
	public String showForm(SubscribeForm subscribeForm) {
		return "/subscribe/form";
	}

	@PostMapping("/")
	public String submitForm(SubscribeForm subscribeForm) {
		return "redirect:/subscribe/confirmation.html";
	}
}