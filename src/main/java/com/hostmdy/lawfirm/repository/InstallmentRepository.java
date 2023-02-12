package com.hostmdy.lawfirm.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.lawfirm.domain.Installment;

public interface InstallmentRepository extends CrudRepository<Installment,Long>{
	Optional<Installment> findByName(String name);
}
