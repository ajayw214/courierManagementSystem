package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.entities.Courier;
import com.app.entities.Customer;
import com.app.service.ICourierService;
import com.app.service.ICustomerService;
import com.app.service.IFeedbackService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	@Autowired
	private ICourierService courierService;
	
	@Autowired
	private IFeedbackService feedbackService;
	
	
	public CustomerController() {
		// TODO Auto-generated constructor stub
		System.out.println("in customer controller");
	}
	@PostMapping("/addCourier/{custId}")
	public ResponseEntity<?> addNewCourier(@PathVariable @Valid long custId,@RequestBody @Valid Courier courier) {
		try {
			System.out.println("in courier controller ");
			System.out.println(courier);
			return ResponseEntity.status(HttpStatus.CREATED).body(courierService.insertCourierDetails(courier, custId));
		} catch (RuntimeException e) {
			System.out.println("in add new courier err " + e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
	@GetMapping("/getAllCouriersById/{custId}")
	public List<Courier> getAllCouriersByCustomerId(@PathVariable @Valid long custId) {
		return courierService.getCouriersById(custId);
	}

	@GetMapping("getACourierDetailsByCourierId/{cId}")
	public ResponseEntity<?> getCourierDetails(@PathVariable @Valid long cId)
	{
		return new ResponseEntity<>(courierService.getCourierDetailsByCourierId(cId), HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?>AddNewCustomer(@RequestBody @Valid Customer customer){
		
		try {
			System.out.println("in add new customer " + customer.getId());// id : null
             
			return ResponseEntity.status(HttpStatus.CREATED).body(customerService.insertCustomerDetails(customer));
			
		} catch (RuntimeException e) {
			System.out.println("in add new customer err " + e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	
	}
	@PostMapping("/addFeedback")
	public ResponseEntity<?> addNewFeedback(@RequestParam("id") long customerId, @RequestParam("message") String message) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(feedbackService.insertFeedbackDetails(customerId, message));
		} catch (RuntimeException e) {
			System.out.println("in add new feedback err " + e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage()));
		}
	}
	
}

