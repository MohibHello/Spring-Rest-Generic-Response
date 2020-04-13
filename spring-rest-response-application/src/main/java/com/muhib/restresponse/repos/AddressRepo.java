package com.muhib.restresponse.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muhib.restresponse.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{

}
