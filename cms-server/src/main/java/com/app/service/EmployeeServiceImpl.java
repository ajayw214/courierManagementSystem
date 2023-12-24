package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customException.ResourceNotFoundException;
import com.app.dao.IBranchRepository;
import com.app.dao.IEmployeeRepository;
import com.app.dto.EmployeeDTO;
import com.app.dto.LoginRequestDTO;
import com.app.entities.Branch;
import com.app.entities.Employee;
import com.app.entities.RoleEnum;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	 private IEmployeeRepository empRepo;

	@Autowired
	private IBranchRepository branchRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public EmployeeDTO authenticateEmployee(LoginRequestDTO request) {
		
		Employee emp=empRepo.findByEmailAndPassword(request.getEmail(),request.getPassword())
		.orElseThrow(()-> new ResourceNotFoundException("Invalid credential!!!"));
		return  mapper.map(emp, EmployeeDTO.class);
	}

	@Override
	public Employee insertEmployeeDetails(Employee transientEmp, long branchId ) {
		 Branch branch = branchRepo.findById(branchId).get();
	       transientEmp.setBranch(branch);
	       transientEmp=empRepo.save(transientEmp);
	       return transientEmp;
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> empList = empRepo.findAll();
		List<EmployeeDTO> empDto=new ArrayList<EmployeeDTO>();
		for(Employee empList1:empList ) 
			empDto.add( mapper.map(empList1, EmployeeDTO.class));
		
		return empDto;
	}

	@Override
	public EmployeeDTO getAnEmployeeDetails(long empId) {
		Employee emp = empRepo.findById(empId).get();
		EmployeeDTO empDto = new EmployeeDTO();
		empDto = mapper.map(emp, EmployeeDTO.class);
		return empDto;
	}

	@Override
	public EmployeeDTO updateEmployeeDetails(Employee detachedEmp) {
		empRepo.findById(detachedEmp.getId()).get();
		Branch branch = branchRepo.findById(detachedEmp.getBranch().getId()).get();
		detachedEmp.setBranch(branch);
		Employee emp = empRepo.save(detachedEmp);
		EmployeeDTO empDto = new EmployeeDTO();
		empDto = mapper.map(emp, EmployeeDTO.class);
		return empDto;
	}

	@Override
	public String deleteEmployeeDetails(long empId) {
		String mesg = "Deleting employee details failed!!!";
		if(empRepo.existsById(empId))
		{
			empRepo.deleteById(empId);
			mesg = "Deleted employee details of employee of id " + empId;
		}
		return mesg;
	}

	@Override
	public List<Employee> getAllDeliveryBoysOfABranch(long branchId, RoleEnum valueOf) {
		List<Employee> employeeList = empRepo.findByRoleAndBranchId(RoleEnum.valueOf("DELIVERY_BOY"), branchId);
		return employeeList;
	}

	@Override
	public Employee getByEmail(String email) {
		return empRepo.findByEmail(email);
	}

}
