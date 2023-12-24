package com.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.entities.Customer;
import com.app.entities.Employee;
import com.app.service.EmployeeServiceImpl;
//import com.app.service.UserService;
import com.app.service.ICustomerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
@Slf4j
public class SignInSignUpController {

	
	@Autowired
	private ICustomerService customerService;
	
	
	
	@Autowired
	private EmployeeServiceImpl employeeService;

	// add a method to authenticate user . In case of success --send back token , o.w
	// send back err mesg
	@PostMapping("/signin")
	public ResponseEntity<?> validateUser(@RequestBody @Valid AuthRequest request) {
	try {
			
			
			
			
			
			//////////////////////////////////  updated--17/09/22   //////////////////////////////////////////////////////////////
			
//			return ResponseEntity.ok(new AuthResp("Auth successful!", utils.generateJwtToken(authenticatedDetails)));
			Map<String, Object> map = new HashMap<>();
			map.put("status", "Auth successful");
			Employee authEmp= employeeService.getByEmail(request.getEmail());
			Customer authCustomer = customerService.getByEmail(request.getEmail());
			if (authEmp!=null) {
				map.put("user", authEmp);
				map.put("id", authEmp.getId());
				map.put("role", authEmp.getRole());
				return ResponseEntity.ok(new AuthResp("Auth successful!" ,authEmp,null));
			} else if (authCustomer!=null)
				{
				map.put("user", authCustomer);
				map.put("id", authCustomer.getId());
				map.put("role", authCustomer.getRole());
				return ResponseEntity.ok(new AuthResp("Auth successful!",null,authCustomer));
				}
			else {
				Map<String,Object>errorMap=new HashMap<>();
				errorMap.put("status","invalid credentials");
				return ResponseEntity.ok(errorMap);
			}
		} catch (Exception e) {
			// send back err resp code
			System.out.println("err "+e);
			Map<String, Object> errorMap = new HashMap<>();
			errorMap.put("status","Error");
			errorMap.put("message",e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMap);
		}

	}
	//add request handling method for user registration
	@PostMapping("/signup")
	public ResponseEntity<?> userRegistration(@RequestBody @Valid Customer customer)
	{
		System.out.println("in reg customer : customer "+ customer +" roles "+ customer.getRole());//{....."roles" : [ROLE_USER,...]}
		//invoke service layer method , for saving : user info + associated roles info
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.insertCustomerDetails(customer));		
	}
}

