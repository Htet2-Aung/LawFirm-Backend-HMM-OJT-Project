package com.hostmdy.lawfirm.domain;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cases {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Case Title must be filled")
	private String caseTitle;

	@NotBlank(message = "Description Title must be filled")
	@Column(columnDefinition="TEXT")
	private String description;

	
	private String caseStatus;
	
	@NotNull(message = "Attendent is required")
	private Integer attenCourtRoom;

	

	private LocalDate startDate;
	private  LocalTime startTime;
	

	private LocalDate endDate;
	private LocalTime endTime;
	private String username;
	private String lawyerName;
	

	@OneToOne
	//@JsonIgnore
	private Contract contract;
	
	//one cases has one category (want category id in case table)
	@ManyToOne//(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id",nullable = true)
	private Category category;		

	//one cases has one Court information but one Court has many cases (want court id in case table)
	@ManyToOne//(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "court_id",nullable = true)
	private Court court;
	


}
