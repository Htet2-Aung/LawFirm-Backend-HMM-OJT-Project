package com.hostmdy.lawfirm.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Court {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	private String courtName;
	private String address;
	private String township;
	private String city;
	
	@OneToMany(mappedBy = "court",fetch = FetchType.EAGER,
			cascade = CascadeType.REFRESH,orphanRemoval = true)
	@JsonIgnore
	private List<Cases> cases;

	
	
	
	

}
