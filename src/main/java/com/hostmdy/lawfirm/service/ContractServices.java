package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.lawfirm.domain.Contract;

public interface ContractServices {

	Contract saveOrUpdate(Contract contract, Long appointmentId);

	List<Contract> findAll();

	Optional<Contract> findById(Long id);
	
	void deleteById(Long id);

	Contract updateContract(Contract contract) ;
	
}
