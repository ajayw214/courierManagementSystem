package com.app.dto;

import com.app.entities.Customer;
import com.app.entities.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@AllArgsConstructor
public class AuthResp {
	private String message;
	//private String jwt;
	private Employee emp;
	private Customer cust;
	
	
	public AuthResp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthResp(String message, Employee emp, Customer cust) {
		super();
		this.message = message;
	//	this.jwt = jwt;
		this.emp = emp;
		this.cust = cust;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	@Override
	public String toString() {
		return "AuthResp [message=" + message + ", emp=" + emp + ", cust=" + cust + "]";
	}
	
	
	
}
