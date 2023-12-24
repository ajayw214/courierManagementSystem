package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Employee;
import com.app.entities.RoleEnum;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
	//add a finder method for login
	Optional<Employee> findByEmailAndPassword(String em, String pass);

	//add an employee 
		//Done with inherited method
	//get all employees
		//Done with inherited method
	//get  an employee details
		//Done with inherited methods
	//update employee details
		//Done with inherited method
	//delete employee by id
		//Done with inherited menthod
	//get all delivery boys of a particular branch(By branchId)
		//Done with inherited methods
		//List<EmployeeEntity> findByBr
	//get an employee from beanchId and role="BRANCH_ADMN"
		Employee findByBranchIdAndRole(Long id,RoleEnum valueOf);
	//get all delivery boys of a particular branch
		List<Employee> findByRoleAndBranchId(RoleEnum valueOf, Long id);
		
		Employee findByEmail(String email);
		
}
