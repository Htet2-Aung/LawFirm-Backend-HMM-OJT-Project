package com.hostmdy.lawfirm.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Appointment;
import com.hostmdy.lawfirm.domain.CreateStatus;
import com.hostmdy.lawfirm.domain.InqueryForm;
import com.hostmdy.lawfirm.domain.User;
import com.hostmdy.lawfirm.repository.AppointmentRepository;
import com.hostmdy.lawfirm.repository.InqueryFormRepository;
import com.hostmdy.lawfirm.repository.UserRepository;
import com.hostmdy.lawfirm.service.InqueryFormService;

import jakarta.validation.Valid;

@Service
public class InqueryFormServiceImpl implements InqueryFormService {

	private final InqueryFormRepository inqueryFormRepository;
	private final UserRepository userRepository;
	private final AppointmentRepository appointmentRepository;

	@Autowired
	public InqueryFormServiceImpl(InqueryFormRepository inqueryFormRepository, UserRepository userRepository,AppointmentRepository appointmentRepository) {
		super();
		this.inqueryFormRepository = inqueryFormRepository;
		this.userRepository = userRepository;
		this.appointmentRepository=appointmentRepository;
	}

	
	@Override
	public List<InqueryForm> findAll() {
		return (List<InqueryForm>) inqueryFormRepository.findAll();
	}

	@Override
	public Optional<InqueryForm> findById(Long id) {
		return inqueryFormRepository.findById(id);
	}

//	@Override
//	public Optional<InqueryForm> findByuserId(Long userId) {
//		return inqueryFormRepository.findByUserId(userId);
//	}

	@Override
	public InqueryForm updateInqueryForm(InqueryForm inqueryForm, User user) {
		// TODO Auto-generated method stub
		
		
				Long inqueryId = inqueryForm.getId();
				Appointment appointment = inqueryFormRepository.findById(inqueryId).get().getAppointment();
				
				if(appointment !=null) {
					
					inqueryForm.setAppointment(appointment);
					inqueryForm.setAppointmentStatus(CreateStatus.CREATED);
					
					appointment.setInqueryForm(inqueryForm);
					appointmentRepository.save(appointment);
					
				}				
				else {
					inqueryForm.setAppointmentStatus(CreateStatus.NO_CREATE);
				}
				
				inqueryForm.setUsername(user.getUsername());
				user.getInqueryForms().add(inqueryForm);
				inqueryForm.setUsers(user);
				inqueryForm.setPhoneNo(user.getPhoneNo());
				
				userRepository.save(user);
				
				return inqueryFormRepository.save(inqueryForm);
		

	}

	@Override
	public void deleteById(Long id) {
		inqueryFormRepository.deleteById(id);
		
	}

	@Override
	public List<InqueryForm> findAll(String username) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username).get();
		System.out.println(user.toString());
		
		List<InqueryForm> userInqueryForm = new ArrayList<InqueryForm>();
		
		//get all inquerys
		List<InqueryForm> inqueryForms = (List<InqueryForm>) inqueryFormRepository.findAll();
		System.out.println(inqueryForms);
		for(InqueryForm inq:inqueryForms) {
			if(inq.getUsers().getId() == user.getId())
				userInqueryForm.add(inq);
		}
		
		return userInqueryForm;
	}
	
//	@Override
//	public InqueryForm saveOrupdate(@Valid InqueryForm inqueryForm, Long userId) {
//		// TODO Auto-generated method stub	
//		User user = userRepository.findById(userId).get();
//		inqueryForm.setUsers(user);
//		inqueryForm.setPhoneNo(user.getPhoneNo());
//		user.getInqueryForms().add(inqueryForm);						
//		return inqueryFormRepository.save(inqueryForm);
//		
//	}

	@Override
	public InqueryForm saveOrupdate(@Valid InqueryForm inqueryForm, String name) {
		// TODO Auto-generated method stub
		System.out.println("In save or update :"+name);
				User user = userRepository.findByUsername(name).get();
				
					//project - user
				inqueryForm.setUsers(user);
				inqueryForm.setPhoneNo(user.getPhoneNo());
				inqueryForm.setUsername(user.getUsername());
				user.getInqueryForms().add(inqueryForm);
										
				return inqueryFormRepository.save(inqueryForm);
					
				}


	@Override
	public List<InqueryForm> findByUserId(Long id) {
		// TODO Auto-generated method stub
		List<InqueryForm> resultedInqueryForms=new ArrayList<>();
		List<InqueryForm> inqueryForms = (List<InqueryForm>) inqueryFormRepository.findAll();
		
		
		for(InqueryForm inq:inqueryForms) {
			if(inq.getUsers().getId() == id)
				resultedInqueryForms.add(inq);
			
		}
		return resultedInqueryForms;
	}
				
}
