package com.udemy.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.constant.ViewConstant;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;

@Controller
@RequestMapping("/contacts")
public class ContactController 
{
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	
	@GetMapping("/cancel")
	public String cancel()
	{
		return "redirect:/contacts/showcontacts";
	}
	
//	@GetMapping("/contactForm")
//	private String redirectContactForm(Model model)
//	{
//		model.addAttribute("contactModel",new ContactModel());
//		return ViewConstant.CONTACT_FORM;
//	}
	
	
	@GetMapping("/contactForm")
	private String redirectContactForm(@RequestParam(name="id", required = false) Integer id,Model model)
	{
		ContactModel contacM =  new ContactModel();
		if( id != 0)
		{
			contacM = contactService.findContacbyIdModel(id);
		}
		 
	    model.addAttribute("contactModel",contacM);
		return ViewConstant.CONTACT_FORM;
	}
	
	
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel,Model model)
	{
		LOG.info("**" + contactModel );
		
		if( null != contactService.addContact(contactModel))
		{
			model.addAttribute("result",1);
		}
		else
		{
			model.addAttribute("result",0);
		}
		
		
		return "redirect:/contacts/showcontacts";
	}
	
	
	@GetMapping("/showcontacts")
	public ModelAndView showContacts()
	{
		ModelAndView mv = new ModelAndView( ViewConstant.CONTACTS);
		
		mv.addObject("contacts",contactService.listAllContacts() );
		
		return mv;
	}
	
	
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id", required = true) Integer id)
	{
		contactService.removeContac(id);
		return showContacts();
	}

}
