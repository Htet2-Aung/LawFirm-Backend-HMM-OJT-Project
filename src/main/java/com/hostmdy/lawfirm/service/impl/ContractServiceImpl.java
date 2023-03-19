package com.hostmdy.lawfirm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.lawfirm.domain.Appointment;
import com.hostmdy.lawfirm.domain.Cases;
import com.hostmdy.lawfirm.domain.Contract;
import com.hostmdy.lawfirm.domain.CreateStatus;
import com.hostmdy.lawfirm.repository.AppointmentRepository;
import com.hostmdy.lawfirm.repository.CasesRepository;
import com.hostmdy.lawfirm.repository.ContractRepository;
import com.hostmdy.lawfirm.service.ContractServices;

@Service
public class ContractServiceImpl implements ContractServices  {
	
	
	private final ContractRepository contractRepository;
	private final AppointmentRepository appointmentRepository;
	private final CasesRepository casesRepository;
	
	
	
    @Autowired
	public ContractServiceImpl(ContractRepository contractRepository, AppointmentRepository appointmentRepository, CasesRepository casesRepository) {
		super();
		this.contractRepository = contractRepository;
		this.appointmentRepository = appointmentRepository;
		this.casesRepository = casesRepository;
	}

    @Override
	public Contract saveOrUpdate(Contract contract, Long appointmentId) {
    	
    	Appointment appointment = appointmentRepository.findById(appointmentId).get();
    	appointment.setContractStatus(CreateStatus.CREATED);
		
		appointment.setContract(contract);
		contract.setUsername(appointment.getUsername());
		contract.setLawyerName(appointment.getLawyerName());
		contract.setAppointment(appointment);
		return contractRepository.save(contract);
	}

	@Override
	public List<Contract> findAll() {
		// TODO Auto-generated method stub
		return (List<Contract>) contractRepository.findAll();
	}

	@Override
	public Optional<Contract> findById(Long id) {
		// TODO Auto-generated method stub
		return contractRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		Appointment appointment=contractRepository.findById(id).get().getAppointment();
		appointment.setContractStatus(CreateStatus.NO_CREATE);
		appointment.setContract(null);
		appointmentRepository.save(appointment);
		
		Cases cases=contractRepository.findById(id).get().getCases();
		if(cases!=null)
		{
			cases.setContract(null);
			casesRepository.save(cases);
		}
		contractRepository.deleteById(id);
		
	}

	@Override
	public Contract updateContract(Contract contract) {
		// TODO Auto-generated method stub
		//get original associated case object of contract
		Long contractId=contract.getId();
		Cases cases=contractRepository.findById(contractId).get().getCases();
		Appointment appointment = contractRepository.findById(contractId).get().getAppointment();
		contract.setAppointment(appointment);
		if(cases !=null) {
			//contract-case
			contract.setCases(cases);
			//cases.setContract(contract);
			
		}				
				
			return contractRepository.save(contract);
		
	}

	

}
