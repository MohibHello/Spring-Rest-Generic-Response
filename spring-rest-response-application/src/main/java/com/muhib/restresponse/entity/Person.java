package com.muhib.restresponse.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "person",fetch = FetchType.EAGER)
	private List<Address> address;
	
}
