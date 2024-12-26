package com.wfm.workforcemanager.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.wfm.workforcemanager.entity.OTPvalidation;


public interface OtpRepo extends JpaRepository<OTPvalidation, String>{
	
	public OTPvalidation findByOtp(int otp);
}
