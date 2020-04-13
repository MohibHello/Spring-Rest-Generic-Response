package com.muhib.restresponse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.muhib.restresponse.entity.Address;
import com.muhib.restresponse.repos.AddressRepo;
import com.muhib.restresponse.util.GenericResponse;
import com.muhib.restresponse.util.GenericResponseBuilder;

@Service
public class AddressServiceImpl implements AddressService {

	GenericResponse response = null;

	@Autowired
	AddressRepo repo;

	@Override
	public ResponseEntity<Object> getAdresses() {
		try {
			List<Address> data = repo.findAll();
			response = GenericResponseBuilder.buildSuccess(data);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = GenericResponseBuilder.buildException(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> addAddress(Address address) {
		try {
			Address data = repo.save(address);
			response = GenericResponseBuilder.buildSuccess(data);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = GenericResponseBuilder.buildException(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> updateAddress(Address address) {
		try {
			Address data = repo.save(address);
			response = GenericResponseBuilder.buildSuccess(data);			
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = GenericResponseBuilder.buildException(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> getAddress(long id) {
		try {
			Address data = repo.findById(id).orElse(new Address());
			response = GenericResponseBuilder.buildSuccess(data);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = GenericResponseBuilder.buildException(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> removeAddress(long id) {
		try {
			response = GenericResponseBuilder.buildSuccess("deleted");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = GenericResponseBuilder.buildException(e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
