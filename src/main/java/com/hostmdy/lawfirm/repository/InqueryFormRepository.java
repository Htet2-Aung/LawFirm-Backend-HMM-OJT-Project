package com.hostmdy.lawfirm.repository;



import org.springframework.data.repository.CrudRepository;

import com.hostmdy.lawfirm.domain.InqueryForm;

public interface InqueryFormRepository extends CrudRepository<InqueryForm, Long>{
	
//	Optional<InqueryForm> findByUserId(Long userId);
}
