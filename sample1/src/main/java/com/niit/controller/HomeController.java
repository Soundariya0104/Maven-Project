package com.niit.controller;


	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.controller.dao.UserDAO;
import com.niit.controller.daoimpl.UserDAOImpl;

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
		public String showlogin()
		{
			return "login";
		}

		
		@RequestMapping("/validate")
		public ModelAndView example(@RequestParam("id") String id,@RequestParam("password") String password){
				UserDAO obj=new UserDAOImpl();
				if(obj.isValidCredentials(id,password)){
				ModelAndView model=new ModelAndView("success");
				return model;
				}
			ModelAndView model=new ModelAndView("invalid");
			model.addObject("result","check your credentials");
			return model;
			}
	}
	


