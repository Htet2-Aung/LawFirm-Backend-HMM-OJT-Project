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
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Description must be filled in the contract")
	@Lob
	@Column(columnDefinition = "Text")
	private String conDescription;

	//one contract has one case (one case is created for one contract)
	private LocalDate contractDate;
	
	@Enumerated(EnumType.STRING)
	private CreateStatus paymentStatus;
	
	private String username;
	private String lawyerName;
	@Enumerated(EnumType.STRING)
	private CreateStatus caseCreated;
	private Double lawyerLandingFees;

	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="appointment_id",nullable = true)
	//@JsonIgnore
	private Appointment appointment;
	
	//one contract has one case (want case id in contract table)
	@OneToOne
	@JoinColumn(name = "case_id",nullable = true)
	@JsonIgnore
	private Cases cases;
	
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="payment_id",nullable = true)
	private Payment payment;
  
	@PrePersist
	void OnCreate() {
		this.caseCreated=CreateStatus.NO_CREATE;
		this.paymentStatus = CreateStatus.NO_CREATE;
}

}
