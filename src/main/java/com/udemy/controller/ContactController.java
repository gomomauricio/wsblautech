package com.udemy.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.udemy.component.UsuarioConvert;
import com.udemy.constant.ViewConstant;
import com.udemy.entity.Contact;
import com.udemy.entity.UsuarioM;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;
import com.udemy.service.impl.UsuarioMServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactController.
 */
@Controller
@RequestMapping("/contacts")
public class ContactController 
{
	
	/** The Constant LOG. */
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	/** The contact service. */
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	

	@Autowired
	@Qualifier("usuarioConvert")
	private UsuarioConvert usuarioConvert;
	
	/** The usuario M service impl. */
	@Autowired
	UsuarioMServiceImpl usuarioMServiceImpl;  
	
	
	/**
	 * Cancel.
	 *
	 * @return the string
	 */
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
	
	
	/**
 * Redirect contact form.
 *
 * @param id the id
 * @param model the model
 * @return the string
 */
@GetMapping("/contactForm")
	private String redirectContactForm(@RequestParam(name="id", required = false) Integer id,Model model)
	{
		ContactModel contacM =  new ContactModel();
		if( id != 0)
		{
//			contacM = contactService.findContacbyIdModel(id);
			UsuarioM usuariom = usuarioMServiceImpl.consultarPorId(id);
			contacM = usuarioConvert.convertUsuarioM2ContactModel(usuariom);
		}
		 
	    model.addAttribute("contactModel",contacM);
		return ViewConstant.CONTACT_FORM;
	}
	
	
	/**
	 * Adds the contact.
	 *
	 * @param contactModel the contact model
	 * @param model the model
	 * @return the string
	 */
	@PostMapping("/addcontact")
	public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel,Model model)
	{
		LOG.info("**" + contactModel );
		
//		if( null != contactService.addContact(contactModel))
		Integer id_a = 0;
		List<UsuarioM> usuarios = usuarioMServiceImpl.consultarTodos();
		for(UsuarioM usuariom : usuarios )
		{
			id_a = usuariom.getId();
		}
		id_a++;
	
		if(contactModel.getId() == null || contactModel.getId() > 0) contactModel.setId(id_a);
		UsuarioM usuariom = usuarioConvert.convertContactModel2UsuarioM(contactModel);
		
		LOG.info(">>> " + usuariom);

		if( null != usuarioMServiceImpl.guardar(usuariom))
		{
			model.addAttribute("result",1);
		}
		else
		{
			model.addAttribute("result",0);
		}
		
		
		return "redirect:/contacts/showcontacts";
	}
	
	
	/**
	 * Show contacts.
	 *
	 * @return the model and view
	 */
	@GetMapping("/showcontacts")
	public ModelAndView showContacts()
	{
		ModelAndView mv = new ModelAndView( ViewConstant.CONTACTS);
		
		List<UsuarioM> usuarios = usuarioMServiceImpl.consultarTodos();
		
//		List<ContactModel> contactos = contactService.listAllContacts();
		List<ContactModel> contactos = new ArrayList<ContactModel>();
		
		for( UsuarioM usuariom : usuarios) 
		{
			ContactModel contacto = usuarioConvert.convertUsuarioM2ContactModel(usuariom);
			contactos.add(contacto);
		}
	 
		
		mv.addObject("contacts", contactos);
		
		return mv;
	}
	
	
	/**
	 * Removes the contact.
	 *
	 * @param id the id
	 * @return the model and view
	 */
	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id", required = true) Integer id)
	{
		System.out.println("id = " + id);
//		contactService.removeContac(id);
		UsuarioM user = usuarioMServiceImpl.consultarPorId(id); 
	    usuarioMServiceImpl.borrar(user);
 
		return showContacts();
	}

}
