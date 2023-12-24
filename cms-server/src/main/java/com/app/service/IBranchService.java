package com.app.service;

import java.util.List;

import com.app.dto.BranchDTO;
import com.app.entities.Branch;

public interface IBranchService {
	Branch insertBranchDetails(Branch transientBranch);
	BranchDTO upadteBranchDetails(Branch detachedBranch);
	String deleteBranchDetails(long branchId);
	List<BranchDTO> getAllBranches();
	BranchDTO getABranchDetails(long branchId);
}
