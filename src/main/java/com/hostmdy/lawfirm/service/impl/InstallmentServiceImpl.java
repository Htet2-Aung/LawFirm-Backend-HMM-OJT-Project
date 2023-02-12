package com.hostmdy.lawfirm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Installment;
import com.hostmdy.lawfirm.repository.InstallmentRepository;
import com.hostmdy.lawfirm.service.InstallmentService;

@Service
public class InstallmentServiceImpl implements InstallmentService{
	
	private final InstallmentRepository installmentRepository;
	
	public InstallmentServiceImpl(InstallmentRepository installmentRepository) {
		super();
		this.installmentRepository = installmentRepository;
	}

	@Override
	public Installment saveOrUpdate(Installment installment) {
		return installmentRepository.save(installment);
	}

	@Override
	public List<Installment> findAll() {
		return (List<Installment>) installmentRepository.findAll();
	}

	@Override
	public Optional<Installment> findById(Long id) {
		return installmentRepository.findById(id);
	}

	@Override
	public Optional<Installment> findByName(String name) {
		return installmentRepository.findByName(name);
	}

	@Override
	public void deleteById(Long id) {
		installmentRepository.deleteById(id);
	}


}
