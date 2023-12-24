package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Branch;

public interface IBranchRepository  extends JpaRepository<Branch, Long>{

	//add branch 
			//Done with inherited methods
		//update branch
			//Done with inherited methods
		//delete a branch 
			//Done with inherited methods
		//get all branches
			//Done with inherited methods
		//get a branch details
			//Done with inherited methods
		//get a branch from pincode
	Branch findByPincode(String pincode);
}
