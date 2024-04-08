package com.security.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.demo.dto.UserInfoDTO;
import com.security.demo.entity.UserInfo;
import com.security.demo.repository.UserInfoRepository;

@Service
public class UserInfoService {
	
	@Autowired
	private UserInfoRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public String addUser(UserInfoDTO userDto) {
		Optional<UserInfo> optional = repository.findByUsername(userDto.getUsername());
		if(optional.isPresent())
			return "User already exists";
		UserInfo user = new UserInfo(userDto.getUsername(), userDto.getFirstName(), userDto.getLastName(),
				userDto.getEmailId(), passwordEncoder.encode(userDto.getPassword())
				, userDto.getRole(), userDto.getDob(), userDto.getAccountStatus());
		
		repository.save(user);
		return "User created";
	}

	public UserInfoDTO getUser(String username) {
		UserInfo user = repository.getById(username);
		UserInfoDTO userDto = new UserInfoDTO(user.getUsername(), user.getFirstName(), user.getLastName(),
				user.getEmailId(), null
				, user.getRole(), user.getDob(), user.getAccountStatus());
		return userDto;
	}

	public String deleteUser(String username) {
		repository.deleteById(username);
		return "User removed from the database";
		
	}

	public List<UserInfoDTO> getAllUsers() {
		List<UserInfo> users = repository.findAll();
		List<UserInfoDTO> usersDto = users.stream().
				map((user)->new UserInfoDTO(user.getUsername(), user.getFirstName(), user.getLastName(),
						user.getEmailId(), null
						, user.getRole(), user.getDob(), user.getAccountStatus()))
				.collect(Collectors.toList());
		return usersDto;
	}

}
