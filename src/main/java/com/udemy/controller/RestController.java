package com.udemy.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.constant.ViewConstant;
import com.udemy.entity.Contact;
import com.udemy.entity.UsuarioM;
import com.udemy.model.ContactModel;
import com.udemy.service.ContactService;
import com.udemy.service.impl.UsuarioMServiceImpl;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
	
	private static final Log LOG = LogFactory.getLog(RestController.class);
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
 
	@Autowired
	UsuarioMServiceImpl usuarioMServiceImpl;  
	
	@GetMapping("/checkrest")  
	public ResponseEntity<String> checkRest(){
		return new ResponseEntity<String>("OK!",HttpStatus.OK);
	}
	
	
	@GetMapping("/listar")  
	public ResponseEntity<List<UsuarioM>> listar(){
		List<UsuarioM> lcm = null;
		try
		{
			 lcm = usuarioMServiceImpl.consultarTodos();
//			LOG.info(lcm);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return new ResponseEntity<List<UsuarioM>>(lcm,HttpStatus.OK);
	}
	
	
	@PostMapping("/detalle")  
	public ResponseEntity<String> detalle(@ModelAttribute(name="id") Integer id)
	{  
		UsuarioM userM = usuarioMServiceImpl.consultarPorId(id);
		
		String res = "Usuario No enontrado";
		
		if(userM != null) res = userM.toString();
		 
		LOG.info("userM-->" + userM);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	
	@PostMapping("/agregar")  
	public ResponseEntity<String> agregar(@ModelAttribute(name="contactModel") UsuarioM userM )
	{  
		String res = "Registro agregado"; 
		
		try
		{
			 usuarioMServiceImpl.guardar(userM);
		}
		catch (Exception e)
		{
			 res = "Error al agregar registro " + e.getMessage();
		}
		 
		LOG.info("res-->" + res);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	
	
	
 
	@PutMapping("/editar")  
	public ResponseEntity<String> editar(@ModelAttribute(name="contactModel") UsuarioM userM )
	{  
		String res = "Registro actualizado";
		UsuarioM user = usuarioMServiceImpl.consultarPorId(userM.getId());
		
		try
		{
			if(user != null)  usuarioMServiceImpl.actualizar(userM);
			else res = "id no valido";
			
		}
		catch (Exception e)
		{
			 res = "Error al actualizar " + e.getMessage();
		}
		
		 
		LOG.info("res-->" + res);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/eliminar")  
	public ResponseEntity<String> eliminar(@ModelAttribute(name="id") Integer id )
	{  
		String res = "Registro eliminado"; 
		UsuarioM user = usuarioMServiceImpl.consultarPorId(id);
		
		try
		{
			if(user != null)  usuarioMServiceImpl.borrar(user);
			else res = "id no valido";
			
		}
		catch (Exception e)
		{
			 res = "Error al eliminar " + e.getMessage();
		}
		
		 
		LOG.info("res-->" + res);
		return new ResponseEntity<String>(res,HttpStatus.OK);
	}
	

}
