package com.hostmdy.lawfirm.domain;

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InqueryForm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Description should not be blank")
	@Lob
	@Column(columnDefinition = "TEXT")
	private String description;

	//@NotBlank(message = "Phone Number should not be blank")
	@Size(min = 11)
	private String phoneNo;

	private String lawyerName;

	private String username;
	@Enumerated(EnumType.STRING)
	private CreateStatus appointmentStatus;

	@ManyToOne
	@JoinColumn(name="user_id")
//	@JsonIgnore
	private User users;
	
	@OneToOne(mappedBy = "inqueryForm", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private Appointment appointment;
	

	@PrePersist
	void onCreate() {
		this.appointmentStatus = CreateStatus.NO_CREATE;
	}

}
