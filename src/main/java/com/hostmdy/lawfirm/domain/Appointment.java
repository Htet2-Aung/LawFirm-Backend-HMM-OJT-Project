package com.hostmdy.lawfirm.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message="Name is not blank")
	private String name;
	
	private Double consultantFees;
	
	private String username;
	
	private String lawyerName;

	@Enumerated(EnumType.STRING)
	private Status clientStatus;

	@Enumerated(EnumType.STRING)
	private Status lawyerStatus;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private LocalTime time;
	@Enumerated(EnumType.STRING)
	private CreateStatus contractStatus;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="inqueryform_id"/*,nullable = false*/)
//	@JsonIgnore
	private InqueryForm inqueryForm;
	
	
	@OneToOne(mappedBy = "appointment",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private Contract contract;
		
	@PrePersist
	void onCreate() {
		this.contractStatus=CreateStatus.NO_CREATE;
		
	}
	
//	@PreUpdate
//	void onUpdate() {
//		this.date = LocalDate.now();
//		this.time = LocalTime.now();
//	}

	public Appointment(@NotBlank(message = "Name is not blank") String name, Double consultantFees, String username,
			String lawyerName, Status clientStatus, Status lawyerStatus, LocalDate date, LocalTime time,
			InqueryForm inqueryForm, CreateStatus contractStatus, Contract contract) {
		super();
		this.name = name;
		this.consultantFees = consultantFees;
		this.username = username;
		this.lawyerName = lawyerName;
		this.clientStatus = clientStatus;
		this.lawyerStatus = lawyerStatus;
		this.date = date;
		this.time = time;
		this.inqueryForm = inqueryForm;
		this.contractStatus = contractStatus;
		this.contract = contract;
	}

	
	
	



	
	
	
	
}
