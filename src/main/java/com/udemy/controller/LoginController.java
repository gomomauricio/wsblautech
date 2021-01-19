package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udemy.model.UserCredential;

@Controller
public class LoginController
{
 
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
//	@GetMapping("/")
//	public String redirectToLogin()
//	{
//		LOG.info("METHOD:redirectToLogin"  );
//		return "redirect:/login";
//	}

	@GetMapping("/login")
	public String showLoginForm(Model model,
								@RequestParam(name="error", required = false ) String error, 
								@RequestParam(name="logout", required = false) String logout )
	{
		LOG.info("showLoginForm=" + " ,error=" + error  + " ,logout="  + logout );
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		model.addAttribute("userCredentials", new UserCredential());
		return "login";
	}
	
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name = "userCredentials") UserCredential userCredential)
	{
		LOG.info("userCredential=" + userCredential );
		if( userCredential.getUsername().equals("user") && userCredential.getUserpasssword().equals("user"))
		{
//			return "contacts";
			return "redirect:/contacts/showcontacts";
		}
		
		return "redirect:/login?error";
	}

	/*
	 //Original
	public String loginCheck(@ModelAttribute(name = "userCredentials") UserCredential userCredential)
	{
		LOG.info("userCredential=" + userCredential );
		if( userCredential.getUsername().equals("user") && userCredential.getUserpasssword().equals("user"))
		{
//			return "contacts";
			return "redirect:/contacts/showcontacts";
		}
		
		return "redirect:/login?error";
	}
	*/
	 
	
	
}
