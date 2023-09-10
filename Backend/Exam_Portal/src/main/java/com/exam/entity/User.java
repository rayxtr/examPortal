package com.exam.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

	@Column(unique = true, nullable = false)
	private String username;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@Column(unique = true, nullable = false)
	@Email(message = "Enter valid email")

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

}
