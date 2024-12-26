package com.jsp.singupLogin.sevicesimple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.singupLogin.entity.OTPvalidation;
import com.jsp.singupLogin.entity.UserInfo;
import com.jsp.singupLogin.exeption.InvalidCridantial;
import com.jsp.singupLogin.exeption.InvalidOTP;
import com.jsp.singupLogin.repository.OtpRepo;
import com.jsp.singupLogin.repository.UserRepo;
import com.jsp.singupLogin.sevices.OTPservice;

/*If u want to save the all log informations need to do in aplication.properties
 * logging.file.name=userlogin.log ->this will create new log file.
 * 
 * You want to give any message User logger
 * create a object--> Logger logger = LoggerFactory.getLogger(OtpSeviceimp.class);
 * logger.info(),logger.warn(),logger.error() etc...
 * 
 * 
 * */

@Service
public class OtpSeviceimp implements OTPservice{
	Logger logger = LoggerFactory.getLogger(OtpSeviceimp.class);
	@Autowired
	private OtpRepo otpRepo;
	@Autowired
	private UserRepo userRepo;

	UserInfo userInfo;

	public OTPvalidation sentotp(Integer otp, String usermail) {
		return otpRepo.save(new OTPvalidation(otp, usermail));
	}

	public UserInfo validation(int otp) {
		OTPvalidation otpValidation = otpRepo.findByOtp(otp);
		if (otpValidation == null) {
			logger.warn("Invalid OTP");
			throw new InvalidCridantial();
		}
		String mail = otpValidation.getUsermail();
		UserInfo user = userRepo.findByUsermail(mail);
		if (user == null) {
			throw new InvalidOTP();
		}
		otpRepo.delete(otpValidation);
		logger.info("User Details");
		return user;
	}
}
