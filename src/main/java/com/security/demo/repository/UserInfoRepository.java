package com.security.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.demo.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String>{
	Optional<UserInfo> findByUsername(String username);
}
