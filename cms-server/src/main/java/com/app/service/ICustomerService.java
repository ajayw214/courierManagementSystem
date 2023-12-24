package com.app.service;

import com.app.entities.Customer;

public interface ICustomerService {
	Customer insertCustomerDetails(Customer transientCustomer);
	public Customer getByEmail(String email);
	
}
