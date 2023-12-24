package com.app.service;

import java.util.List;

import com.app.dto.EmployeeDTO;
import com.app.dto.LoginRequestDTO;
import com.app.entities.Employee;
import com.app.entities.RoleEnum;

public interface IEmployeeService {
	EmployeeDTO authenticateEmployee(LoginRequestDTO request);
	//EmployeeEntity insertEmployeeDetails(EmployeeEntity transientEmp);
	Employee insertEmployeeDetails(Employee transientEmp, long branchId );
	List<EmployeeDTO> getAllEmployees();
	EmployeeDTO getAnEmployeeDetails(long empId);
	EmployeeDTO updateEmployeeDetails(Employee emp);
	String deleteEmployeeDetails(long empId);
	List<Employee> getAllDeliveryBoysOfABranch(long branchId, RoleEnum valueOf);
	public Employee getByEmail(String email);
}
