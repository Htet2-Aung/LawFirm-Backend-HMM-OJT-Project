package com.hostmdy.lawfirm.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.lawfirm.domain.Appointment;
import com.hostmdy.lawfirm.domain.InqueryForm;


public interface InqueryFormRepository extends CrudRepository<InqueryForm, Long>{

//	Optional<Appointment> findByUsername(String name);
	
	Optional<InqueryForm> findByUsername(String username);
}
