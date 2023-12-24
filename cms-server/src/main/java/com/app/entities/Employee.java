package com.app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="employee")
public class Employee extends BaseEntity implements Serializable{

	 
	private static final long serialVersionUID = 1L;
	@Column(length = 20)
	private String firstName;
	@Column(length = 20)
	private String lastName;
	@Column(length = 20, unique = true)
	private String email;
	@Column(length = 350)
	private String password;
	@Column(length = 13)
	private String mobileNo;
	@Enumerated(EnumType.STRING)
	@Column(length = 15)
	private RoleEnum role;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "branch_id")
	private Branch branch;
	
	@JsonIgnore
	@OneToMany(mappedBy = "allotedToDeliveryBoy", cascade = CascadeType.ALL) //or persist
	private List<Courier> couriers;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<Courier> getCouriers() {
		return couriers;
	}

	public void setCouriers(List<Courier> couriers) {
		this.couriers = couriers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mobileNo="
				+ mobileNo + ", role=" + role + ", branch=" + branch + ", couriers=" + couriers + "]";
	}
	
	
}
