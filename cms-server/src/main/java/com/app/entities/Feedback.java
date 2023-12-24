package com.app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="feedback")
public class Feedback  extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Column(length = 300)
	private String message;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customerFeedback;
	
	

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(String message, Customer customerFeedback) {
		super();
		this.message = message;
		this.customerFeedback = customerFeedback;
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
	
	
}
