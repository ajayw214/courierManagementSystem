package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ICustomerRepository;
import com.app.entities.Customer;
import com.app.entities.RoleEnum;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public Customer insertCustomerDetails(Customer transientCustomer) {
		transientCustomer.setRole(RoleEnum.valueOf("CUSTOMER"));
		return customerRepo.save(transientCustomer);
	}

	@Override
	public Customer getByEmail(String email) {
		
		return customerRepo.findByEmail(email);
	}

	
	}


