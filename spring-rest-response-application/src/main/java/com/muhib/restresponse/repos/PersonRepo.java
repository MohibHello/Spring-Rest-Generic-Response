package com.muhib.restresponse.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muhib.restresponse.entity.Person;

public interface PersonRepo extends JpaRepository<Person, Long>  {

}
