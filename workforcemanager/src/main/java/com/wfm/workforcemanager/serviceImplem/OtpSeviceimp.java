package com.wfm.workforcemanager.serviceImplem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfm.workforcemanager.entity.Employee;
import com.wfm.workforcemanager.entity.OTPvalidation;
import com.wfm.workforcemanager.exeption.InvalidCridantial;
import com.wfm.workforcemanager.exeption.InvalidOTP;
import com.wfm.workforcemanager.repository.EmployeeRepo;
import com.wfm.workforcemanager.repository.OtpRepo;
import com.wfm.workforcemanager.service.OTPservice;


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
	private EmployeeRepo employeeRepo;

	Employee employee;

	public OTPvalidation sentotp(Integer otp, String usermail) {
		return otpRepo.save(new OTPvalidation(otp, usermail));
	}

	public Employee validation(int otp) {
		OTPvalidation otpValidation = otpRepo.findByOtp(otp);
		if (otpValidation == null) {
			logger.warn("Invalid OTP");
			throw new InvalidOTP();	
		}
		String mail = otpValidation.getUsermail();
		Employee employee = employeeRepo.findByEmail(mail);
		if (employee == null) {
			throw new InvalidOTP();
		}
		otpRepo.delete(otpValidation);
		logger.info("User Details");
		return employee;
	}
}
