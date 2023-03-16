package com.hostmdy.lawfirm.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	private String cardNumber;
	private LocalDate expireDate;
	private String cvc;
	private String  holderName;
	private Double totalCost;
	private String username;
	private String lawyerName;
	
	
	
	
	@OneToOne(fetch = FetchType.EAGER,mappedBy = "payment")
	@JsonIgnore
	private Contract contract;
	
//	public Payment(String cardNumber, LocalDate expireDate, String cvc, String holderName, Double totalCost
//		) {
//		super();
//		this.cardNumber = cardNumber;
//		this.expireDate = expireDate;
//		this.cvc = cvc;
//		this.holderName = holderName;
//		this.totalCost = totalCost;
//		
//	}
//	public Payment(Long id, String cardNumber, LocalDate expireDate, String cvc, String holderName, Double totalCost
//			) {
//		super();
//		this.id = id;
//		this.cardNumber = cardNumber;
//		this.expireDate = expireDate;
//		this.cvc = cvc;
//		this.holderName = holderName;
//		this.totalCost = totalCost;
//		
//		
//	}
//	
	
	
	
	
	
	
}
