package com.hostmdy.lawfirm.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Contract;
import com.hostmdy.lawfirm.domain.Payment;
import com.hostmdy.lawfirm.repository.ContractRepository;
import com.hostmdy.lawfirm.repository.PaymentRepository;
import com.hostmdy.lawfirm.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	private  final PaymentRepository paymentRepository;
	private final ContractRepository contractRepository;
	
	public PaymentServiceImpl(PaymentRepository paymentRepository, ContractRepository contractRepository) {
		super();
		this.paymentRepository = paymentRepository;
		this.contractRepository = contractRepository;
	}

	@Override
	public Payment SaveOrUpdate(Payment payment,Long contractId) {
		Contract contract= contractRepository.findById(contractId).get();
		
		payment.setContract(contract);
		payment.setUsername(contract.getUsername());
		payment.setLawyerName(contract.getLawyerName());
		contract.setPayment(payment);
		
		return paymentRepository.save(payment);
	}

	@Override
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return (List<Payment>) paymentRepository.findAll();
	}

	@Override
	public Optional<Payment> findById(Long id) {
		// TODO Auto-generated method stub
		return paymentRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
//		Optional<Payment> paymentOpt = paymentRepository.findById(id);
		
		paymentRepository.deleteById(id);
		
	}
	
	

}

