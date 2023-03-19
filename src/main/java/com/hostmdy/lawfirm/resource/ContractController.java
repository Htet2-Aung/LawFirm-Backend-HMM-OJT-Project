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
import com.hostmdy.lawfirm.domain.Contract;
import com.hostmdy.lawfirm.domain.CreateStatus;
import com.hostmdy.lawfirm.repository.AppointmentRepository;
import com.hostmdy.lawfirm.service.AppointmentService;
import com.hostmdy.lawfirm.service.ContractServices;
import com.hostmdy.lawfirm.service.MapValidationErrorService;


import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/contract")
public class ContractController {
	
	private final ContractServices contractService;
	private final MapValidationErrorService errorMapService;
    private final AppointmentRepository appointmentRepository;
	
	@Autowired
	public ContractController(ContractServices contractService, MapValidationErrorService errorMapService, AppointmentRepository appointmentRepository) {
		super();
		this.contractService = contractService;
		this.errorMapService = errorMapService;
		this.appointmentRepository = appointmentRepository;
		
	}

	//@PostMapping("/user/{Id}/create")
	@PostMapping("/create/{appointmentId}")
	public ResponseEntity<?> createContract(@Valid @RequestBody  Contract contract,
			BindingResult result, @PathVariable Long appointmentId,Principal principal) {
		
		System.out.println("appointment id is ;;;;;;;;;;;;;;;;"+appointmentId);
		
		System.out.println("description is "+ contract.getConDescription());
		
			
		Appointment appointment = appointmentRepository.findById(appointmentId).get();
		appointment.setContractStatus(CreateStatus.CREATED);
		
		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);

		if (responseErrorObject != null)
			return responseErrorObject;

		Contract createContract = contractService.saveOrUpdate(contract, appointmentId);
		
		return new ResponseEntity<Contract>(createContract, HttpStatus.CREATED);

	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateContract(@Valid @RequestBody  Contract contract,
			BindingResult result){
		
		ResponseEntity<?> responseErrorObject = errorMapService.validate(result);
		
		if(responseErrorObject!= null)
			return responseErrorObject;
		
		Contract updatedContract = contractService.updateContract(contract);
		
		 return new ResponseEntity<Contract>(updatedContract,HttpStatus.OK);
		}

	@GetMapping("/all")
	public ResponseEntity<List<Contract>> findContract() {
		
		List<Contract> contractList= contractService.findAll();	
			
			
		return new ResponseEntity<>(contractList,HttpStatus.OK);

	}

	@GetMapping("/id/{contractId}")
	public ResponseEntity<?> findById(@PathVariable Long contractId) {
		
		Optional<Contract> contractOptional = contractService.findById(contractId);

		if (contractOptional.isEmpty())
			return new ResponseEntity<String>("Contract with id =" + contractId + " not found", HttpStatus.NOT_FOUND);
		return new ResponseEntity<Contract>(contractOptional.get(), HttpStatus.OK);

	}

	@DeleteMapping("id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {

		contractService.deleteById(id);
		
		return new ResponseEntity<String>("Delelte id=" + id + "is deleted", HttpStatus.OK);
	}

}
