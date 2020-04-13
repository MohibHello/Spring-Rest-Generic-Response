package com.muhib.restresponse.service;

import org.springframework.http.ResponseEntity;

import com.muhib.restresponse.entity.Address;

public interface AddressService {

	public ResponseEntity<Object> getAdresses();
	
	public ResponseEntity<Object> addAddress(Address address);
	
	public ResponseEntity<Object> updateAddress(Address address);
	
	public ResponseEntity<Object> getAddress(long id);
	
	public ResponseEntity<Object> removeAddress(long id);
	
}
