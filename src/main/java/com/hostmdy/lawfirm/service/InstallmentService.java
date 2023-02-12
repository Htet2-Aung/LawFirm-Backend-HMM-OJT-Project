package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.lawfirm.domain.Installment;

public interface InstallmentService {
	
	Installment saveOrUpdate(Installment installment); 
	
	List<Installment> findAll();
	
	Optional<Installment> findById(Long id);
	
	Optional<Installment> findByName(String name);
	
	void deleteById(Long id);

}
