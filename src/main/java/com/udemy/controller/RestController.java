package com.udemy.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.constant.ViewConstant;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	private static final Log LOG = LogFactory.getLog(RestController.class);
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	@GetMapping("/checkrest")  //devuelve un json 
	public ResponseEntity<String> checkRest(){
		return new ResponseEntity<String>("OK!",HttpStatus.OK);
	}
	
	@GetMapping("/listar")  //devuelve un json 
	public ResponseEntity<List<ContactModel>> listar(){
		
		List<ContactModel> lcm = contactService.listAllContacts();
//		LOG.info(lcm);
		String lis = lcm.toString();
		
		return new ResponseEntity<List<ContactModel>>(lcm,HttpStatus.OK);
	}
	
	
	@GetMapping("/detalle")  //devuelve un json 
	public ResponseEntity<String> detalle(@ModelAttribute(name="id") Integer id)
	{ 
		Contact user = contactService.findContacbyId(id);
		
		String res = "Usuario No enontrado";
		
		if(user != null) res = user.toString();
		 
		LOG.info("user-->" + user);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
 
	@GetMapping("/editar")  //devuelve un json 
	public ResponseEntity<String> editar(@ModelAttribute(name="id") Integer id)
	{ 
		Contact user = contactService..findContacbyId(id);
		
		String res = "Usuario No enontrado";
		
		if(user != null) res = user.toString();
		 
		LOG.info("user-->" + user);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	

}
