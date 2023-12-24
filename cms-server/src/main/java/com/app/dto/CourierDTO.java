package com.app.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.app.entities.CategoryEnum;


import com.app.entities.StatusEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CourierDTO {
	private Long id;
	@NotBlank
	private CustomerDTO customerCouriers;
	
	@NotBlank
	private String sendersAddress;
	
	@NotBlank
	private String sendersPincode;
	
	@NotBlank
	private String receiversName;
	
	@NotBlank
	private String receiversAddress;
	
	@NotBlank
	private String receiversPincode;
	
	@NotBlank
	private EmployeeDTO allotedToDeliveryBoy;
	
	@NotBlank
	private Date bookedDate;
	
	@NotBlank
	private StatusEnum status ;
	
	@NotBlank
	private CategoryEnum category;
	
	@NotBlank
	private double weight;
	
	@NotBlank
	private double amount;
	
	

	public CourierDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public CourierDTO(Long id, @NotBlank CustomerDTO customerCouriers, @NotBlank String sendersAddress,
			@NotBlank String sendersPincode, @NotBlank String receiversName, @NotBlank String receiversAddress,
			@NotBlank String receiversPincode, @NotBlank EmployeeDTO allotedToDeliveryBoy, @NotBlank Date bookedDate,
			@NotBlank StatusEnum status, @NotBlank CategoryEnum category, @NotBlank double weight,
			@NotBlank double amount) {
		super();
		this.id = id;
		this.customerCouriers = customerCouriers;
		this.sendersAddress = sendersAddress;
		this.sendersPincode = sendersPincode;
		this.receiversName = receiversName;
		this.receiversAddress = receiversAddress;
		this.receiversPincode = receiversPincode;
		this.allotedToDeliveryBoy = allotedToDeliveryBoy;
		this.bookedDate = bookedDate;
		this.status = status;
		this.category = category;
		this.weight = weight;
		this.amount = amount;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerDTO getCustomerCouriers() {
		return customerCouriers;
	}

	public void setCustomerCouriers(CustomerDTO customerCouriers) {
		this.customerCouriers = customerCouriers;
	}

	public String getSendersAddress() {
		return sendersAddress;
	}

	public void setSendersAddress(String sendersAddress) {
		this.sendersAddress = sendersAddress;
	}

	public String getSendersPincode() {
		return sendersPincode;
	}

	public void setSendersPincode(String sendersPincode) {
		this.sendersPincode = sendersPincode;
	}

	public String getReceiversName() {
		return receiversName;
	}

	public void setReceiversName(String receiversName) {
		this.receiversName = receiversName;
	}

	public String getReceiversAddress() {
		return receiversAddress;
	}

	public void setReceiversAddress(String receiversAddress) {
		this.receiversAddress = receiversAddress;
	}

	public String getReceiversPincode() {
		return receiversPincode;
	}

	public void setReceiversPincode(String receiversPincode) {
		this.receiversPincode = receiversPincode;
	}

	public EmployeeDTO getAllotedToDeliveryBoy() {
		return allotedToDeliveryBoy;
	}

	public void setAllotedToDeliveryBoy(EmployeeDTO allotedToDeliveryBoy) {
		this.allotedToDeliveryBoy = allotedToDeliveryBoy;
	}

	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public void setCategory(CategoryEnum category) {
		this.category = category;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "CourierDTO [id=" + id + ", customerCouriers=" + customerCouriers + ", sendersAddress=" + sendersAddress
				+ ", sendersPincode=" + sendersPincode + ", receiversName=" + receiversName + ", receiversAddress="
				+ receiversAddress + ", receiversPincode=" + receiversPincode + ", allotedToDeliveryBoy="
				+ allotedToDeliveryBoy + ", bookedDate=" + bookedDate + ", status=" + status + ", category=" + category
				+ ", weight=" + weight + ", amount=" + amount + "]";
	}
	
	
}
