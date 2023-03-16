package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.lawfirm.domain.Appointment;
import com.hostmdy.lawfirm.domain.InqueryForm;

import jakarta.validation.Valid;

public interface AppointmentService {
		
	Appointment saveOrUpdate(Appointment appointment, Long inqueryId); 
	
	List<Appointment> findAll();
	
	Optional<Appointment> findById(Long id);
	
	Optional<Appointment> findByName(String name);
	
	void deleteById(Long id);
	
	Appointment updateAppointment(@Valid Appointment appointment, InqueryForm inquery);
	
	
}
