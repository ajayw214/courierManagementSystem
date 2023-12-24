package com.app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="customer")
public class Customer extends BaseEntity  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(length = 20)
	private String firstName;
	
	@Column(length = 20)
	private String lastName;
	
	@Column(length=20,unique = true)
	private String email;
	
	@Column(length=100)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private RoleEnum role;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customerFeedback", cascade = CascadeType.ALL)
	private List<Feedback> feedbacks;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customerCouriers", cascade = CascadeType.ALL)
	private List<Courier> couriers;
	
	
	
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String firstName, String lastName, String email, String password, RoleEnum role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
