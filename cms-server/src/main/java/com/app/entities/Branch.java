package com.app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="branch")
public class Branch  extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(length = 20)
	private String branchName;
	@Column(length = 20)
    private String location;
	@Column(length = 10)
	private String pincode;
	
	@JsonIgnore
	@OneToMany(mappedBy = "branch",cascade = CascadeType.ALL)
    private List<Employee> employees;

	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Branch(String branchName, String location, String pincode, List<Employee> employees) {
		super();
		this.branchName = branchName;
		this.location = location;
		this.pincode = pincode;
		this.employees = employees;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Branch [branchName=" + branchName + ", location=" + location + ", pincode=" + pincode + "]";
	}
	
	
	
}
