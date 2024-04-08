package com.security.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.demo.dto.UserInfoDTO;
import com.security.demo.service.UserInfoService;

@RestController
@RequestMapping(path = "/api/v1")
public class UserInfoController {
	
	@Autowired
	private UserInfoService userInfoService; 
	
	@PostMapping(path = "/users")
	public ResponseEntity<String> addUser(@RequestBody UserInfoDTO userDto)
	{
		String result = userInfoService.addUser(userDto);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@GetMapping(path = "/users/{username}")
	public ResponseEntity<UserInfoDTO> getUser(@PathVariable String username)
	{
		UserInfoDTO result = userInfoService.getUser(username);
		return new ResponseEntity<UserInfoDTO>(result,HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/users/{username}")
	public ResponseEntity<String> deleteUser(@PathVariable String username)
	{
		String result = userInfoService.deleteUser(username);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@GetMapping(path = "/users")
	public ResponseEntity<List<UserInfoDTO>>getAllUsers()
	{
		List<UserInfoDTO> result = userInfoService.getAllUsers();
		return new ResponseEntity<List<UserInfoDTO>>(result,HttpStatus.OK);
	}
}
