package com.hostmdy.lawfirm.domain;





import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long id;
	
	@NotBlank(message = "CategoryName should not be blank")	
	private String categoryName;
	
	@NotBlank(message = "Description should not be blank")
	private String description;
	
	
	

	@OneToMany(mappedBy = "category",fetch = FetchType.EAGER,
			cascade = CascadeType.REFRESH,orphanRemoval = true)
	@JsonIgnore
	private List<Cases> cases;
	
	

	

	

	
	
	
	
	

}
