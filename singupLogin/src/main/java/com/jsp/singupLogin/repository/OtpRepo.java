package com.jsp.singupLogin.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.singupLogin.entity.OTPvalidation;

public interface OtpRepo extends JpaRepository<OTPvalidation, String>{
	
	public OTPvalidation findByOtp(int otp);
}
