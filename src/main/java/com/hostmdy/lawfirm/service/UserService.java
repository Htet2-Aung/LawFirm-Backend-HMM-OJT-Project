package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.lawfirm.domain.User;

public interface UserService {

	User saveOrupdate(User user);
	List<User> findAll();
	Optional<User> findById(Long id);
	Optional<User> findByRole(String role);
	Optional<User> findByUsername(String username);
	Optional<User> getUserById(Long id);
	User createUser(User user);
	
	void deleteById(Long id);
	
	User updateUser(User user);
	Optional<User> findByStatuss(Boolean status);
	
	
	
	
	
	
	
}
