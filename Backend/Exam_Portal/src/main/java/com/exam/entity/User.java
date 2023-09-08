package com.exam.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
	
	@NotBlank
	@NotNull
	@Column(unique = true)
	private String username;
	
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	
	@Column(unique = true)
	@Email(message ="Enter valid email")
	@NotNull
	@NotBlank
	private String email;
	
	
	@NotNull
	@NotBlank
	@NotEmpty
	private String password;
	
	private String phoneNumber;
	
	private String about;
	
	private String gender;
	
	private Boolean enable = true;
	
	private String profileImage;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="user")
	@JsonIgnore
	private Set<UserRole> userRoles= new HashSet<>();
	
	
}
