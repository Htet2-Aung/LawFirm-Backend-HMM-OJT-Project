package com.hostmdy.lawfirm.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.lawfirm.domain.User;
import com.hostmdy.lawfirm.payload.JwtLoginSuccessResponse;
import com.hostmdy.lawfirm.payload.LoginRequest;
import com.hostmdy.lawfirm.security.JwtTokenProvider;
import com.hostmdy.lawfirm.service.MapValidationErrorService;
import com.hostmdy.lawfirm.service.UserService;
import com.hostmdy.lawfirm.validator.UserValidator;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins ="http://localhost:3000")
public class UserController {
	private static final String TOKEN_PREFIX = "Bearer ";
	
	private final UserService userService;
	private final MapValidationErrorService mapErrorService;
	private final UserValidator userValidator;
	private final JwtTokenProvider tokenProvider;
	private final AuthenticationManager authenticationManager;
	

	
	public UserController(UserService userService, MapValidationErrorService mapErrorService,
			UserValidator userValidator, JwtTokenProvider tokenProvider, AuthenticationManager authenticationManager) {
		super();
		this.userService = userService;
		this.mapErrorService = mapErrorService;
		this.userValidator = userValidator;
		this.tokenProvider = tokenProvider;
		this.authenticationManager = authenticationManager;
		
	}
	@PostMapping("/createLawyer")
	public ResponseEntity<?> createLawyer(@Valid @RequestBody User user,BindingResult result){
		user.setRole("Lawyer");
		userValidator.validate(user, result);
		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
		
		if(responseErrorObject != null) {
			return responseErrorObject;
		}
		User createdUser = userService.createUser(user);
		//Category createdCategory = categoryService.SaveOrUpdate(category, Number(id));
		
		
		return new ResponseEntity<User>(createdUser,HttpStatus.CREATED);
		
	}
	@PostMapping("/createUser")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user,BindingResult result){
		user.setRole("User");
		userValidator.validate(user, result);
		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
		
		if(responseErrorObject != null) {
			return responseErrorObject;
		}
		User createdUser = userService.createUser(user);
		//Category createdCategory = categoryService.SaveOrUpdate(category, Number(id));
		
		
		return new ResponseEntity<User>(createdUser,HttpStatus.CREATED);
		
	}
	@PostMapping("/updateUser")
	public ResponseEntity<?> updateUser(@Valid @RequestBody User user,BindingResult result){
		user.setRole("User");
//		userValidator.validate(user, result);
//		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
//		
//		if(responseErrorObject != null) {
//			return responseErrorObject;
//		}
		
		User updatedUser = userService.updateUser(user);
		//Category createdCategory = categoryService.SaveOrUpdate(category, Number(id));
		
		
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
		
	}
	@PostMapping("/updateLawyer")
	public ResponseEntity<?> updateLawyer(@Valid @RequestBody User user,BindingResult result){
		user.setRole("Lawyer");
		System.out.println("In the update lawyer:");
//		userValidator.validate(user, result);
//		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
//		
//		if(responseErrorObject != null) {
//			return responseErrorObject;
//		}
		
		User updatedLawyer = userService.updateUser(user);
		//Category createdCategory = categoryService.SaveOrUpdate(category, Number(id));
		
		
		return new ResponseEntity<User>(updatedLawyer,HttpStatus.OK);
		
	}
	
	@PostMapping("/createAdmin")
	public ResponseEntity<?> createAdmin(@Valid @RequestBody User user,BindingResult result){
		user.setRole("Admin");
		userValidator.validate(user, result);
		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
		
		if(responseErrorObject != null) {
			return responseErrorObject;
		}
		User createdUser = userService.createUser(user);
		//Category createdCategory = categoryService.SaveOrUpdate(category, Number(id));
		
		
		return new ResponseEntity<User>(createdUser,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/all")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<User> userOptional = userService.getUserById(id);
		
		if(userOptional.isEmpty())
			return new ResponseEntity<String>("User with id="+id+" is not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(userOptional.get(),HttpStatus.OK);
		
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<?> findByUsername(@PathVariable String username){
		Optional<User> userOptional = userService.findByUsername(username);
		
		if(userOptional.isEmpty())
			return new ResponseEntity<String>("User with username="+username+"is not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(userOptional.get(),HttpStatus.OK);
	}
	
	@GetMapping("/role/{role}")
	public ResponseEntity<?> findByRole(@PathVariable String role) {
		Optional<User> userOptional = userService.findByRole(role);

		if (userOptional.isEmpty())
			return new ResponseEntity<String>("Role: " + role + " is not found.", HttpStatus.NOT_FOUND);

		return new ResponseEntity<User>(userOptional.get(), HttpStatus.OK);

	}
	
	@GetMapping("/status/{status}")
	public ResponseEntity<?> findByStatuss(@PathVariable Boolean status){
		Optional<User> userOptional = userService.findByStatuss(status);
		
		if(userOptional.isEmpty())
			return new ResponseEntity<String>("Status: "+status+" is not found.", HttpStatus.NOT_FOUND);
		return new ResponseEntity<User>(userOptional.get(),HttpStatus.OK);
	}

	
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		userService.deleteById(id);
		
		return new ResponseEntity<String>("Delete id=" + id, HttpStatus.OK);
		
	}
	
//	@PostMapping("/login")
//	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest,BindingResult result){
//		
//		System.out.println("In the user controller");
//		ResponseEntity<?> errorResponse = mapErrorService.validate(result);
//		
//		if(errorResponse != null)
//			return errorResponse;
//		
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword())
//					);
//		System.out.println(authentication.getName());
//		
//		Optional<User> userOpt = userService.findByUsername(loginRequest.getUsername());
//		if(!authentication.getName().equals(userOpt.get().getUsername()))
//			return new ResponseEntity<String>("User Email && Password incorrect",HttpStatus.NOT_FOUND);
//		
//		
//			return new ResponseEntity<User>(userOpt.get(),HttpStatus.OK);
//		
//			
//	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest,BindingResult result){
		
		System.out.println("In the user controller");
		ResponseEntity<?> errorResponse = mapErrorService.validate(result);
		
		if(errorResponse != null)
			return errorResponse;
		
		Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword())
				);
		Optional<User> userOpt = userService.findByUsername(loginRequest.getUsername());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = TOKEN_PREFIX+tokenProvider.generateToken(authentication);
		
		return ResponseEntity.ok(new JwtLoginSuccessResponse(true,jwt,userOpt.get()));
		
		
	}
	

}
