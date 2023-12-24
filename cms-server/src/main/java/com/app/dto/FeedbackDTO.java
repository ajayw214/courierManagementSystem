package com.app.dto;

import javax.validation.constraints.NotBlank;

import com.app.entities.Customer;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class FeedbackDTO {
	
	private long id;
	
	@NotBlank
	private String message;
	
	@NotBlank
	private Customer customerFeedback;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Customer getCustomerFeedback() {
		return customerFeedback;
	}

	public void setCustomerFeedback(Customer customerFeedback) {
		this.customerFeedback = customerFeedback;
	}

	@Override
	public String toString() {
		return "FeedbackDTO [id=" + id + ", message=" + message + ", customerFeedback=" + customerFeedback + "]";
	}
	
	
}
