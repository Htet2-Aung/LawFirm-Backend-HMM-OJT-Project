package com.hostmdy.lawfirm.domain;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="Users")
public class User implements UserDetails{


	/**
	 * 
	 */
	private static final long serialVersionUID = -8592791161823976931L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	private String lastName;
	private String address;
	private Double cost;
	private String nrc;
	private String phoneNo;
	
	@Enumerated(EnumType.STRING)
	private LawyerCase statuss;
	
	private String accountName;
	private String role;
	private String username;
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Lob
	@Column(columnDefinition = "TEXT")
	private String description;
	private String certificate;
	private String field;
	private String licenseNo;
	private LocalDate licenseExpireDate;
	private String imageURL;
	@Transient
	private String confirmPassword;
	
	@OneToMany(mappedBy = "users",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnore
	private List<InqueryForm> inqueryForms;

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
}
