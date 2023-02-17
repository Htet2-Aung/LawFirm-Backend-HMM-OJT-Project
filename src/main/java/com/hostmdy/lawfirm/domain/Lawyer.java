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
public class Lawyer {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String lawyerName;
		
		public Lawyer(String lawyerName) {
			super();
			this.lawyerName = lawyerName;
		}
		
		
}
