package com.app.dto;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class BranchDTO {
	private Long id;
	@NotBlank(message = "Branch name must be supplied")
	private String branchName;
	@NotBlank(message = "Location must be supplied")
	private String location;
	@NotBlank(message = "Pincode must be supplied")
	private String pincode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "BranchDTO [id=" + id + ", branchName=" + branchName + ", location=" + location + ", pincode=" + pincode
				+ "]";
	}
	
	
}
