package com.hostmdy.lawfirm.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Installment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Double amount;
	
	private Double paidAmount;

	public Installment(String name, Double amount, Double paidAmount) {
		super();
		this.name = name;
		this.amount = amount;
		this.paidAmount = paidAmount;
	}
	
	
}
