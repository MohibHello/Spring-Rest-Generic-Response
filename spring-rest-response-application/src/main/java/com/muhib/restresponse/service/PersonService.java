package com.muhib.restresponse.service;

import org.springframework.http.ResponseEntity;

import com.muhib.restresponse.entity.Person;

public interface PersonService {

	public ResponseEntity<Object> getPersons();
	
	public ResponseEntity<Object> addPerson(Person person);
	
	public ResponseEntity<Object> updatePerson(Person person);
	
	public ResponseEntity<Object> getPerson(long id);
	
	public ResponseEntity<Object> removePerson(long id);
	
}
