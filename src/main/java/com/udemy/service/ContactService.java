package com.udemy.service;

import java.util.List;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

public interface ContactService {
	
	public abstract ContactModel addContact(ContactModel contactModel);
	
	public abstract List<ContactModel> listAllContacts();
	
	public abstract Contact findContacbyId( Integer id);
	
	public abstract void removeContac( Integer id);
	
	public ContactModel findContacbyIdModel(Integer id);
	 
	

}
