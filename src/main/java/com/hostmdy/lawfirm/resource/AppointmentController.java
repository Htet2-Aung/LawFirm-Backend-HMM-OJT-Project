package com.hostmdy.lawfirm.resource;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.lawfirm.domain.Appointment;
import com.hostmdy.lawfirm.domain.CreateStatus;
import com.hostmdy.lawfirm.domain.InqueryForm;
import com.hostmdy.lawfirm.domain.User;
import com.hostmdy.lawfirm.repository.InqueryFormRepository;
import com.hostmdy.lawfirm.service.AppointmentService;
import com.hostmdy.lawfirm.service.InqueryFormService;
import com.hostmdy.lawfirm.service.MapValidationErrorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/appointment")
@CrossOrigin(origins = "http://localhost:3000/")
public class AppointmentController {

	private final AppointmentService appointmentService;
	private final InqueryFormRepository inqueryFormRepository;
	private final MapValidationErrorService mapErrorService;
	private final InqueryFormService inqueryFormService;
	

	@Autowired
	public AppointmentController(AppointmentService appointmentService, MapValidationErrorService mapErrorService, InqueryFormRepository inqueryFormRepository, InqueryFormService inqueryFormService) {
		super();
		this.appointmentService = appointmentService;
		this.inqueryFormRepository = inqueryFormRepository;
		this.mapErrorService = mapErrorService;
		this.inqueryFormService = inqueryFormService;
	}

	@PostMapping("/create/{inqueryId}")
	public ResponseEntity<?> createAppointment(@Valid @RequestBody Appointment appointment, BindingResult result,
			@PathVariable Long inqueryId) {
		
		//get user info
		

		//InqueryForm inquery= inqueryFormRepository.findById(inqueryId).get();
		//inquery.setAppointmentStatus(true);
		//inqueryFormRepository.save(inquery);
		
		
		ResponseEntity<?> responseErrorObj = mapErrorService.validate(result);

		if (responseErrorObj != null)
			return responseErrorObj;

		Appointment createAppointment = appointmentService.saveOrUpdate(appointment, inqueryId);
		return new ResponseEntity<Appointment>(createAppointment, HttpStatus.CREATED);
		
	}


	@PostMapping("/update/{inqueryId}")
	public ResponseEntity<?> updateAppointment(@Valid @RequestBody Appointment appointment, BindingResult result, Principal principal,@PathVariable Long inqueryId) {
		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
		System.out.println("In the appointment update, user name is ;;;;;;;;;;;;;;;;"+appointment.getUsername());
		System.out.println("In the appointment update, inqueryid:"+inqueryId);
		
		System.out.println("In the appointment update,:"+appointment);
		List<Appointment> applst = appointmentService.findAll();
		InqueryForm inqueryForm = new InqueryForm();
		
		for(Appointment app: applst) {
			if(app.getInqueryForm().getId() == inqueryId)
			{
				inqueryForm = app.getInqueryForm();
			}
		}
		
		
//		InqueryForm inquery= inqueryFormService.findById(inqueryId).get();
//		System.out.println("In the appointment update, inqueryid:"+inquery);
		
		if (responseErrorObject != null)
			return responseErrorObject;

		Appointment updateAppointment = appointmentService.updateAppointment(appointment,inqueryForm);

		return new ResponseEntity<Appointment>(updateAppointment, HttpStatus.OK);
		
	
	}

//	@PostMapping("/update")
//	public ResponseEntity<?> updateAppointment(@Valid @RequestBody  Appointment appointment,
//			BindingResult result){
//		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
//		
//		if(responseErrorObject!= null)
//			return responseErrorObject;
//		
//		Appointment updateAppointment = appointmentService.updateAppointment(appointment);
//		
//		 return new ResponseEntity<Appointment>(updateAppointment,HttpStatus.OK);
//		}
	
	@GetMapping("/all")
	public List<Appointment> findAll() {
		return appointmentService.findAll();
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Appointment> appOptional = appointmentService.findById(id);

		if (appOptional.isEmpty())
			return new ResponseEntity<String>("Project with id: " + id + "is not found", HttpStatus.NOT_FOUND);

		return new ResponseEntity<Appointment>(appOptional.get(), HttpStatus.OK);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name) {
		Optional<Appointment> appOptional = appointmentService.findByName(name);

		if (appOptional.isEmpty())
			return new ResponseEntity<String>("Appointment Name: " + name + " is not found.", HttpStatus.NOT_FOUND);

		return new ResponseEntity<Appointment>(appOptional.get(), HttpStatus.OK);

	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id,Principal principal) {
		
		InqueryForm inqueryForm = appointmentService.findById(id).get().getInqueryForm();
		inqueryForm.setAppointmentStatus(CreateStatus.NO_CREATE);
//		inqueryForm.setAppointment(null);
		appointmentService.deleteById(id);
		return new ResponseEntity<String>("Delete id=" + id, HttpStatus.OK);
	}

}
