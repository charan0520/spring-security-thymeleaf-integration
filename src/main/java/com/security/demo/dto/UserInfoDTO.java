package com.security.demo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfoDTO {

	private String username;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String role;
	private LocalDate dob;
	private String accountStatus;
}
