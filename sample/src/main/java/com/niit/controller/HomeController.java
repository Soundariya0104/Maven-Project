package com.niit.controller;


	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

	@Controller
	public class HomeController {
		
		@RequestMapping("/home")
		public String showAboutUs()
		{
			return "home";
		}
		
		@RequestMapping("/register")
		public String showContactUs()
		{
			return "registration";
		}

		@RequestMapping("/login")
		public String shoeLogin()
		{
			return "login";
		}
	}


