package com.jsp.singupLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.singupLogin.entity.UserInfo;

public interface UserRepo extends JpaRepository<UserInfo,String>{

	
	@Query(nativeQuery = true, value = "select * from user_info where userid=?1 or usermail=?2")
	public UserInfo login(String val1,String val2);
	
//	@Query(nativeQuery = true, value = "SELECT * FROM user_info WHERE usermail=?1")
	public UserInfo findByUsermail(String mail);
	
}
