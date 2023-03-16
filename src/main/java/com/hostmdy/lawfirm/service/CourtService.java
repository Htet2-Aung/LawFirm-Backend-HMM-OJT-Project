package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.lawfirm.domain.Category;
import com.hostmdy.lawfirm.domain.Court;

import jakarta.persistence.Id;
import jakarta.validation.Valid;

public interface CourtService {
	
	Court SaveOrUpdate(Court court,Long caseId);
	
	Court updateCourt (Court court);
	
	List<Court> findAll();
	
	Optional<Court> findById(Long id);
	
	void deleteById(Long id);
	
	//form link
	Optional<Court> getCourtById(Long id);

	Court SaveOrUpdate(Court court);
	
	
	
	
	

}
