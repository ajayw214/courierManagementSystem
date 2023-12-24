package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {

	//sign up a customer 
			//Done with inherited methods
		Customer findByEmail(String email);
}
