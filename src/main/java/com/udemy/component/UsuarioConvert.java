package com.udemy.component;

import org.springframework.stereotype.Component;

import com.udemy.entity.Contact;
import com.udemy.entity.UsuarioM;
import com.udemy.model.ContactModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactConverter.
 */
@Component("usuarioConvert")
public class UsuarioConvert {

	 
	/**
	 * Convert usuario M 2 contact.
	 *
	 * @param usuariom the usuariom
	 * @return the contact
	 */
	public Contact convertUsuarioM2Contact(UsuarioM usuariom)
	{
		Contact contact = new Contact();
		
		contact.setCity(usuariom.getCity());
		contact.setFirstname(usuariom.getFirstname());
		contact.setId(usuariom.getId());
		contact.setLastname(usuariom.getLastname());
		contact.setTelephone(usuariom.getTelephone());
		
		return contact;
	}
	
	
	 
	/**
	 * Convert usuario M 2 contact model.
	 *
	 * @param usuariom the usuariom
	 * @return the contact model
	 */
	public ContactModel convertUsuarioM2ContactModel(UsuarioM usuariom)
	{
		ContactModel contactModel = new ContactModel();
		
		contactModel.setCity(usuariom.getCity());
		contactModel.setFirstname(usuariom.getFirstname());
		contactModel.setId(usuariom.getId());
		contactModel.setLastname(usuariom.getLastname());
		contactModel.setTelephone(usuariom.getTelephone());
		
		return contactModel;
	}
	
	/**
	 * Convert contact 2 usuario M.
	 *
	 * @param contact the contact
	 * @return the usuario M
	 */
	public UsuarioM convertContact2UsuarioM(Contact contact)
	{
		UsuarioM usuariom = new UsuarioM();
		
		usuariom.setCity(contact.getCity());
		usuariom.setFirstname(contact.getFirstname());
		usuariom.setId(contact.getId());
		usuariom.setLastname(contact.getLastname());
		usuariom.setTelephone(contact.getTelephone());
		
		return usuariom;
	}
	
	/**
	 * Convert contact model 2 usuario M.
	 *
	 * @param contactModel the contact model
	 * @return the usuario M
	 */
	public UsuarioM convertContactModel2UsuarioM(ContactModel contactModel)
	{
		UsuarioM usuariom = new UsuarioM();
		
		usuariom.setCity(contactModel.getCity());
		usuariom.setFirstname(contactModel.getFirstname());
		usuariom.setId(contactModel.getId());
		usuariom.setLastname(contactModel.getLastname());
		usuariom.setTelephone(contactModel.getTelephone());
		
		return usuariom;
	}
	
	
}
