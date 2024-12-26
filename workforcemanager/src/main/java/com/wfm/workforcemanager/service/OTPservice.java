package com.wfm.workforcemanager.service;

import com.wfm.workforcemanager.entity.Employee;
import com.wfm.workforcemanager.entity.OTPvalidation;

public interface OTPservice {
	public OTPvalidation sentotp(Integer otp, String usermail);
	public Employee validation(int otp);
}
