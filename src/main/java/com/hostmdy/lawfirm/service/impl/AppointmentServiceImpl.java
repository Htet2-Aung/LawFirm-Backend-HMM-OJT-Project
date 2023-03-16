package com.hostmdy.lawfirm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Appointment;
import com.hostmdy.lawfirm.domain.Contract;
import com.hostmdy.lawfirm.domain.CreateStatus;
import com.hostmdy.lawfirm.domain.InqueryForm;
import com.hostmdy.lawfirm.domain.Status;
import com.hostmdy.lawfirm.repository.AppointmentRepository;
import com.hostmdy.lawfirm.repository.InqueryFormRepository;
import com.hostmdy.lawfirm.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	private final AppointmentRepository appointmentRepository;
	private final InqueryFormRepository inqueryFormRepository;

	@Autowired
	public AppointmentServiceImpl(AppointmentRepository appointmentRepository, InqueryFormRepository inqueryFormRepository) {
		super();
		this.appointmentRepository = appointmentRepository;
		this.inqueryFormRepository = inqueryFormRepository;
	}

	@Override
	public Appointment saveOrUpdate(Appointment appointment, Long inqueryId) {
		// TODO Auto-generated method stub
		InqueryForm inqueryForm = inqueryFormRepository.findById(inqueryId).get();
		inqueryForm.setAppointmentStatus(CreateStatus.CREATED);
		inqueryForm.setAppointment(appointment);
		
		
		appointment.setLawyerName(inqueryForm.getLawyerName());
		appointment.setUsername(inqueryForm.getUsername());
		appointment.setClientStatus(Status.Disagree);
		appointment.setLawyerStatus(Status.Disagree);
		appointment.setInqueryForm(inqueryForm);
		return appointmentRepository.save(appointment);
	}

	@Override
	public List<Appointment> findAll() {
		
		return  (List<Appointment>) appointmentRepository.findAll();
	}

	@Override
	public Optional<Appointment> findById(Long id) {
		// TODO Auto-generated method stub
		return appointmentRepository.findById(id);
	}

	@Override
	public Optional<Appointment> findByName(String name) {
		
		return appointmentRepository.findByName(name);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
		appointmentRepository.deleteById(id);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment,InqueryForm inqueryForm) {
		
		appointment.setUsername(inqueryForm.getUsername());
		appointment.setLawyerName(inqueryForm.getLawyerName());		
		
		inqueryForm.setAppointment(appointment);
		appointment.setInqueryForm(inqueryForm);
		inqueryFormRepository.save(inqueryForm);
		
		
		return appointmentRepository.save(appointment);
	}





	

	
	
	
	

}
