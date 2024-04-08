package com.security.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfo {
	@Id
	private String username;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String role;
	private LocalDate dob;
	private String accountStatus;
}
