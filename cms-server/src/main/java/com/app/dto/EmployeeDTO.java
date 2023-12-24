package com.app.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.app.entities.RoleEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude = "password")
public class EmployeeDTO {
	
	private long id;
	
	@NotBlank(message = "First Name must be supplied")
	@Length(min = 5,max=20, message = "Invalid length of chars for  first name")
	private String firstName;
	
	@NotBlank(message = "Last Name must be supplied")
	private String lastName;
	
	@NotBlank(message = "Email must be supplied ...")
	@Email(message = "Invalid Email Format")
	private String email;
	
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Blank or invalid password")
	//password should it added during :1.  serialization(java->json) 2. de- serialization(json-->java) 
	//Ans : 2
	@JsonProperty(access =Access.WRITE_ONLY)
	private String password;
	
	@NotBlank(message = "Mobile number must be supplied ...")
	private String mobileNo;
	
	@NotBlank(message = "Role must be supplied ...")
	private RoleEnum role;
	
	@NotBlank
	private BranchDTO branch;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public BranchDTO getBranch() {
		return branch;
	}

	public void setBranch(BranchDTO branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", role=" + role + ", branch=" + branch + "]";
	}
	
	
	
	
}
