package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Courier;
import com.app.entities.Employee;
import com.app.entities.RoleEnum;
import com.app.entities.StatusEnum;
import com.app.service.ICourierService;
import com.app.service.IEmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/branchAdmin")
@CrossOrigin(origins = "*")
@Validated
@Slf4j
public class BranchAdminController {

	@Autowired
	private IEmployeeService empService;
	
	@Autowired
	private ICourierService courierService;
	
	@GetMapping("/getAllDeliveryBoysOfABranch/{branchId}")//this branchId fetched from session of employee
	public List<Employee> getAllDeliveryBoysOfAParticularBranch(@PathVariable long branchId) {
		List<Employee> employeeList = empService.getAllDeliveryBoysOfABranch(branchId, RoleEnum.valueOf("DELIVERY_BOY"));
		return employeeList;
	}
	
	@GetMapping("/getAllOrdersToBePickedUp/{empId}")//this empId fetched from session of employee
	public List<Courier> getAllOrdersToBePickedUp(@PathVariable long empId, StatusEnum valueOf) {
		List<Courier> courierList = courierService.getAllOrdersToBePickedUp(empId, StatusEnum.valueOf("READY_FOR_PICKUP"));
		return courierList;			
	}
	//axios.put(config.serverURL +`/branchAdmin/alotCourierToOneOfDeliveryBoyToPickUp?dBid=${dbid}&courierId=${courierId}`)
 
	@PutMapping("/alotCourierToOneOfDeliveryBoyToPickUp")
	public Courier alotCourierToOneOfTheDeliveryBoyOfABranch
	(@RequestParam("dbid") long dbid, @RequestParam("courierId") long courierId) {
		Courier courierEntity = courierService.alotCourierToOneOfDeliveryBoy(dbid, courierId);
		return courierEntity;
	}
	
	@GetMapping("/getAllOrdersToBeDelivered/{empId}")//this empId fetched from session of employee
	public List<Courier> getAllOrdersToBeDelivered(@PathVariable long empId, StatusEnum valueOf) {
		List<Courier> courierList = courierService.getAllOrdersToBeDelivered(empId, StatusEnum.valueOf("DISPATCHED"));
		return courierList;			
	}
	
	@PutMapping("/alotCourierToOneOfDeliveryBoyToDeliver")
	public Courier alotCourierToOneOfTheDeliveryBoyToDeliver(@RequestParam("dbid") long dbid, @RequestParam("courierId") long courierId) {
		Courier courierEntity = courierService.alotCourierToOneOfDeliveryBoy(dbid,courierId);
		return courierEntity;
	}
}
