package com.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IBranchRepository;
import com.app.dto.BranchDTO;
import com.app.entities.Branch;

@Service
@Transactional
public class BranchServiceImpl  implements IBranchService{

	@Autowired
	private IBranchRepository branchRepo;
    
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Branch insertBranchDetails(Branch transientBranch) {
		 
		return branchRepo.save(transientBranch);
	
		
	}

	@Override
	public BranchDTO upadteBranchDetails(Branch detachedBranch) {
		branchRepo.findById(detachedBranch.getId()).get();
		Branch branch = branchRepo.save(detachedBranch);
		BranchDTO branchDto = new BranchDTO();
		branchDto = mapper.map(branch, BranchDTO.class);
		return branchDto;
	}

	@Override
	public String deleteBranchDetails(long branchId) {
		String mesg = "Deleting employee details failed!!!";
		if(branchRepo.existsById(branchId))
		{
			branchRepo.deleteById(branchId);
			mesg = "Deleted employee details of employee of id " + branchId;
		}
		return mesg;
	}

	@Override
	public List<BranchDTO> getAllBranches() {
		List<Branch> branch = branchRepo.findAll();
		List<BranchDTO> branchDto = new ArrayList<BranchDTO>();
		for(Branch b1 : branch)
		{
			branchDto.add(mapper.map(b1, BranchDTO.class));
		}
		return branchDto;
	}

	@Override
	public BranchDTO getABranchDetails(long branchId) {
		Branch branch = branchRepo.findById(branchId).get();
		BranchDTO branchDto = new BranchDTO();
		branchDto = mapper.map(branch, BranchDTO.class);
		return branchDto;
	}

	

}
