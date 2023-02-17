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
	@Column(updatable = false, unique = true)
	private String name;
	
	private Double consultantFees;

	@Enumerated(EnumType.STRING)
	private Status clientStatus;

	@Enumerated(EnumType.STRING)
	private Status lawyerStatus;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	private LocalTime time;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="inqueryform_id",nullable = false)
	@JsonIgnore
	private InqueryForm inqueryForm;
	
	@OneToOne(mappedBy = "appointment",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private Contract contract;
	
	public Appointment(@NotBlank(message = "Name is not blank") String name, Double consultantFees, Status clientStatus,
			Status lawyerStatus, LocalDate date, LocalTime time) {
		super();
		this.name = name;
		this.consultantFees = consultantFees;
		this.clientStatus = clientStatus;
		this.lawyerStatus = lawyerStatus;
		this.date = date;
		this.time = time;
	}
	
	@PrePersist
	void onCreate() {
		this.date = LocalDate.now();
		this.time = LocalTime.now();
	}
	
	@PreUpdate
	void onUpdate() {
		this.date = LocalDate.now();
		this.time = LocalTime.now();
	}


	
	
	
	
}
