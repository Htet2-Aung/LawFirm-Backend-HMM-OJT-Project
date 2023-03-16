package com.hostmdy.lawfirm.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.lawfirm.domain.InqueryForm;
import com.hostmdy.lawfirm.domain.User;

import jakarta.validation.Valid;

public interface InqueryFormService {
	
	List<InqueryForm> findAll();
	Optional<InqueryForm> findById(Long id);
//	Optional<InqueryForm> findByuserId(Long userId);
	void deleteById(Long id);
	
	InqueryForm updateInqueryForm(InqueryForm inqueryForm, User user) ;
	List<InqueryForm> findAll(String username);
	InqueryForm saveOrupdate(@Valid InqueryForm inqueryForm, String name);
//	InqueryForm saveOrupdate(@Valid InqueryForm inqueryForm, Long userId);
	List<InqueryForm> findByUserId(Long id);
	
	
}
