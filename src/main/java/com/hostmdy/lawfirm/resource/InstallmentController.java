package com.hostmdy.lawfirm.resource;

import java.util.List;
import java.util.Optional;

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

import com.hostmdy.lawfirm.domain.Installment;
import com.hostmdy.lawfirm.service.InstallmentService;
import com.hostmdy.lawfirm.service.MapValidationErrorService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/installment")
@CrossOrigin(origins = "http://localhost:3000/")
public class InstallmentController {
	private final InstallmentService installmentService;
	private final MapValidationErrorService mapErrorService;
	
	
	public InstallmentController(InstallmentService installmentService, MapValidationErrorService mapErrorService) {
		super();
		this.installmentService = installmentService;
		this.mapErrorService = mapErrorService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createInstallment(@Valid @RequestBody Installment installment,BindingResult result){
		
		ResponseEntity<?> responseErrorObj = mapErrorService.validate(result);
		
		if(responseErrorObj != null) 
			return responseErrorObj;
		
		Installment createinstallment = installmentService.saveOrUpdate(installment);
		return new ResponseEntity<Installment>(createinstallment,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Installment> findAll(){
		return installmentService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Installment> installmentOptional = installmentService.findById(id);
		
		if(installmentOptional.isEmpty())
			return new ResponseEntity<String>("Installment with id: "+id+"is not found",HttpStatus.NOT_FOUND);
		return new ResponseEntity<Installment>(installmentOptional.get(),HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name){
		Optional<Installment> installmentOptional = installmentService.findByName(name);
		
		if(installmentOptional.isEmpty())
			return new ResponseEntity<String>("Installment with name: "+name+"is not found",HttpStatus.NOT_FOUND);
		return new ResponseEntity<Installment>(installmentOptional.get(),HttpStatus.OK);
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		installmentService.deleteById(id);
		return new ResponseEntity<String>("Delete id="+id,HttpStatus.OK);
	}
}
