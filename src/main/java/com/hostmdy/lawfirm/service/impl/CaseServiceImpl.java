package com.hostmdy.lawfirm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Cases;
import com.hostmdy.lawfirm.domain.Category;
import com.hostmdy.lawfirm.domain.Contract;
import com.hostmdy.lawfirm.domain.Court;
import com.hostmdy.lawfirm.domain.CreateStatus;
import com.hostmdy.lawfirm.repository.CasesRepository;
import com.hostmdy.lawfirm.repository.ContractRepository;
import com.hostmdy.lawfirm.service.CasesService;

import jakarta.validation.Valid;

@Service
public class CaseServiceImpl implements CasesService  {

	private final CasesRepository casesRepository;
	private final ContractRepository contractRepository;
	
	
	@Autowired
	public CaseServiceImpl(CasesRepository casesRepository, ContractRepository contractRepository) {
		super();
		this.casesRepository = casesRepository;
		this.contractRepository = contractRepository;
	}

	

	@Override
	public List<Cases> findAll() {
		// TODO Auto-generated method stub
		return (List<Cases>) casesRepository.findAll();
	}

	@Override
	public Optional<Cases> findById(Long id) {
		// TODO Auto-generated method stub
		return casesRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		//get all contract at first stage
		List<Contract> conlst=(List<Contract>) contractRepository.findAll();
		for(Contract con: conlst) {
			if (con.getCases().getId()==id)
				con.setCases(null);
		}
		
		casesRepository.deleteById(id);
	}

	@Override
	public Cases updateCase(Cases cases) {
		// TODO Auto-generated method stub
		return casesRepository.save(cases);
	}


	@Override
	public Cases saveOrUpdate(@Valid Cases cases, Contract con, Court court, Category category) {
		// TODO Auto-generated method stub
		con.setCaseCreated(CreateStatus.CREATED);
		con.setCases(cases);
		cases.setContract(con);
		
		cases.setLawyerName(con.getLawyerName());
		cases.setUsername(con.getUsername());
		cases.setCourt(court);
		court.getCases().add(cases);
		cases.setCategory(category);
		category.getCases().add(cases); 
		
		//contractRepository.save(con);
        Cases UpdateCases=casesRepository.save(cases);
       
       
		return UpdateCases;
		
	}

	@Override
	public Cases saveOrUpdate(Cases cases, Long contractId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

	

}
