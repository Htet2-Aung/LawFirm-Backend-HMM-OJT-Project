package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.lawfirm.domain.Cases;
import com.hostmdy.lawfirm.domain.Category;
import com.hostmdy.lawfirm.domain.Contract;
import com.hostmdy.lawfirm.domain.Court;

import jakarta.validation.Valid;


public interface CasesService {
	
	

	List<Cases> findAll();

	Optional<Cases> findById(Long id);
	
	void deleteById(Long id);

	

	

	Cases updateCase(Cases cases);

	//Cases saveOrUpdate(Cases cases, Contract con);

	//Cases saveOrUpdate(Cases cases, Court court);

	Cases saveOrUpdate(@Valid Cases cases, Contract con, Court court, Category category);

	Cases saveOrUpdate(Cases cases, Long contractId);

	
	
	

}
