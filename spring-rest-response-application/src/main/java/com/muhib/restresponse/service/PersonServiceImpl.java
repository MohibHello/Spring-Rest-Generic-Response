package com.muhib.restresponse.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.muhib.restresponse.entity.Address;
import com.muhib.restresponse.entity.Person;
import com.muhib.restresponse.repos.AddressRepo;
import com.muhib.restresponse.repos.PersonRepo;
import com.muhib.restresponse.util.GenericResponse;
import com.muhib.restresponse.util.GenericResponseBuilder;

@Service
public class PersonServiceImpl implements PersonService {

	private GenericResponse response = null;

	@Autowired
	private PersonRepo repo;
	@Autowired
	private AddressRepo addRepo;

	@Override
	public ResponseEntity<Object> getPersons() {
		try {
			List<Person> findAll = repo.findAll();
			if (!findAll.isEmpty()) {
				response = GenericResponseBuilder.buildSuccess(findAll);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				response = GenericResponseBuilder.buildFailure(findAll);
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response = GenericResponseBuilder.buildException(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<Object> addPerson(Person person) {
		try {
			Person save = repo.save(person);
			
			List<Address> address2 = save.getAddress();
			
			for (int i = 0; i <address2.size(); i++) {
				Address address = address2.get(i);
				address.setPerson(save);
				addRepo.save(address);
			}
			response.setData(save);
			response = GenericResponseBuilder.buildSuccess(save);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			response = GenericResponseBuilder.buildException("Exception message :"+e.getMessage()+"Cause :"+e.getCause());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> updatePerson(Person person) {
		try {
			Person data = repo.save(person);
			response = GenericResponseBuilder.buildSuccess(data);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = GenericResponseBuilder.buildException(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getPerson(long id) {
		try {
			Person data = repo.findById(id).orElse(null);
			if (data != null) {
				response = GenericResponseBuilder.buildSuccess(data);
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				response = GenericResponseBuilder.buildFailure(data);
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response = GenericResponseBuilder.buildException(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> removePerson(long id) {
		try {
			repo.deleteById(id);
			response = GenericResponseBuilder.buildSuccess("deleted");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = GenericResponseBuilder.buildException(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
