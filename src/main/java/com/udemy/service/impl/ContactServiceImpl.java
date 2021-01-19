package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.component.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService
{
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	@Override
	public ContactModel addContact(ContactModel contactModel) {

		Contact contact = contactRepository.save( contactConverter.convertContacModel2Contact(contactModel) );
		
		return contactConverter.convertContac2ContactModel(contact);
	}

	
	
	@Override
	public List<ContactModel> listAllContacts() {
		
		List<Contact> contacts = contactRepository.findAll();
		System.out.println(" numero de contactos " + contacts.size() + " - " + contacts.get(0).getFirstname());
		List<ContactModel> contactsModel = new ArrayList<ContactModel>();
		
		for(Contact contact : contacts)
		{
			contactsModel.add( contactConverter.convertContac2ContactModel(contact) );
		}
		
		
		return contactsModel;
	}



	@Override
	public Contact findContacbyId(Integer id) {

		
		return contactRepository.findById(id);
	}
	
	@Override
	public ContactModel findContacbyIdModel(Integer id) {
		return contactConverter.convertContac2ContactModel(findContacbyId(id));
	}



	@Override
	public void removeContac(Integer id) {
		
		Contact contact = findContacbyId( id);
		
		if(null != contact)
		{
			contactRepository.delete(contact);
		}

		
		
	}
	
	
	

}
