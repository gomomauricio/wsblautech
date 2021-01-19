package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.udemy.model.Person;
import com.udemy.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService
{

	@Override
	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<Person>();
		people.add(new Person("Carlos", "38"));
		people.add(new Person("Maria", "43"));
		people.add(new Person("Andrea", "54"));
		people.add(new Person("MaUricio", "67"));
		
		return people;
	}
	

}
