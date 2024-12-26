package com.jsp.singupLogin.sevices;

import com.jsp.singupLogin.entity.OTPvalidation;
import com.jsp.singupLogin.entity.UserInfo;

public interface OTPservice {
	public OTPvalidation sentotp(Integer otp, String usermail);
	public UserInfo validation(int otp);
}
