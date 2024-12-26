package com.jsp.SecurityPro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.SecurityPro.entity.UserInfo;


public interface UserInfoRepo extends JpaRepository<UserInfo, String> {
	public UserInfo findByUsername(String username);
}
