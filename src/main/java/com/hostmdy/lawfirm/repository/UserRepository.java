package com.hostmdy.lawfirm.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.lawfirm.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{

	Optional<User> findByRole(String role);

	Optional<User> findByStatuss(Boolean status);
	
  Optional<User> findByUsername(String username);
	
	Optional<User> getUserById(Long id);

	

}
