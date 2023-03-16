package com.hostmdy.lawfirm.resource;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.lawfirm.domain.Appointment;
import com.hostmdy.lawfirm.domain.InqueryForm;
import com.hostmdy.lawfirm.domain.User;
import com.hostmdy.lawfirm.repository.UserRepository;
import com.hostmdy.lawfirm.service.InqueryFormService;
import com.hostmdy.lawfirm.service.MapValidationErrorService;

import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/inquery")
@CrossOrigin(origins = "http://localhost:3000/")
public class InqueryFormController {

	private final InqueryFormService inqueryFormService;
	private final MapValidationErrorService mapErrorService;
	private final UserRepository userRepository;

	public InqueryFormController(InqueryFormService inqueryFormService, MapValidationErrorService mapErrorService, UserRepository userRepository) {
		super();
		this.inqueryFormService = inqueryFormService;
		this.mapErrorService = mapErrorService;
		this.userRepository = userRepository;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createInqueryForm(@Valid @RequestBody InqueryForm inqueryForm,BindingResult result,Principal principal){
		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
		
		if(responseErrorObject != null)
			return responseErrorObject;
			
		InqueryForm createInquery = inqueryFormService.saveOrupdate(inqueryForm,principal.getName());
		return new ResponseEntity<InqueryForm>(createInquery, HttpStatus.CREATED);
		
	}
	
//	@PostMapping("/create/{userId}")
//	public ResponseEntity<?> createInqueryForm(@Valid @RequestBody InqueryForm inqueryForm, BindingResult result,@PathVariable Long userId) {
//		System.out.println("User Id: "+userId);
//		User user = userRepository.findById(userId).get();
//		
//		
//		ResponseEntity<?> responseErrorObj = mapErrorService.validate(result);
//
//		if (responseErrorObj != null)
//			return responseErrorObj;
//
//		InqueryForm createInquery = inqueryFormService.saveOrupdate(inqueryForm, user.getId());
//		return new ResponseEntity<InqueryForm>(createInquery, HttpStatus.CREATED);
//	}

	
	@PostMapping("/update")
	public ResponseEntity<?> updateInqueryForm(@Valid @RequestBody InqueryForm inqueryForm, BindingResult result, Principal principal) {
		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
		System.out.println("In the update"+principal.getName());
		User user= userRepository.findByUsername(principal.getName()).get();
		if (responseErrorObject != null)
			return responseErrorObject;

		InqueryForm updateInqueryForm = inqueryFormService.updateInqueryForm(inqueryForm,user);

		return new ResponseEntity<InqueryForm>(updateInqueryForm, HttpStatus.OK);
	}

//	@GetMapping("/all")
//	public List<InqueryForm> findAll() {
//		return inqueryFormService.findAll();
//	}

	@GetMapping("/all")
	public List<InqueryForm> findAll(Principal principal) {
		User user = userRepository.findByUsername(principal.getName()).get();
		if(user.getRole().equals("Admin"))
			return inqueryFormService.findAll();
		
		return inqueryFormService.findByUserId(user.getId());
	}
	@GetMapping("/all1")
	public List<InqueryForm> findAll() {
		
		
			return inqueryFormService.findAll();
		
		
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<InqueryForm> inqueryOptional = inqueryFormService.findById(id);
		if (inqueryOptional.isEmpty())
			return new ResponseEntity<String>("InqueryForm id:" + id + "is not found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<InqueryForm>(inqueryOptional.get(), HttpStatus.OK);
	}

//	@GetMapping("/userid/{userid}")
//	public ResponseEntity<?> findByUserId(@PathVariable Long userid){
//		Optional<InqueryForm> inOptional = inqueryFormService.findByuserId(userid);
//		if(inOptional.isEmpty())
//			return new ResponseEntity<String>("User Id:"+userid+" is not found",HttpStatus.NOT_FOUND);
//		return new ResponseEntity<InqueryForm>(inOptional.get(),HttpStatus.OK);
//	}

	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleById(@PathVariable Long id) {
		inqueryFormService.deleteById(id);
		return new ResponseEntity<String>("Deleted id= " + id, HttpStatus.OK);
	}
}
