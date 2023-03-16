package com.hostmdy.lawfirm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.InqueryForm;
import com.hostmdy.lawfirm.domain.User;
import com.hostmdy.lawfirm.exception.UsernameAlreadyExistException;
import com.hostmdy.lawfirm.repository.InqueryFormRepository;
import com.hostmdy.lawfirm.repository.UserRepository;
import com.hostmdy.lawfirm.service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	private final InqueryFormRepository inqueryFormRepository;
	
	private final BCryptPasswordEncoder passwordEncoder;
		
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, InqueryFormRepository inqueryFormRepository) {
		super();
		this.userRepository = userRepository;
		this.inqueryFormRepository = inqueryFormRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User saveOrupdate(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public Optional<User> findByRole(String role) {
		// TODO Auto-generated method stub
		return userRepository.findByRole(role);
	}

	@Override
	public Optional<User> findByStatuss(Boolean status) {
		// TODO Auto-generated method stub
		return userRepository.findByStatuss(status);
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		Long userId = user.getId();
		List<InqueryForm> inquery = userRepository.findById(userId).get().getInqueryForms();
		if(inquery != null) {
			user.setInqueryForms(inquery);
			
		}
		
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public Optional<User> getUserById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

	@Override
	@Transactional
	public User createUser(User user) {
		// TODO Auto-generated method stub
		Optional<User> userOptional = userRepository.findByUsername(user.getUsername());
		
		if(userOptional.isPresent()) {
			throw new UsernameAlreadyExistException("User Email is already exist.");
			
		}
//		System.out.println("In the user service Impl"+userOptional.get());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
		
		return saveOrupdate(user);
	
	}

	

	

}
