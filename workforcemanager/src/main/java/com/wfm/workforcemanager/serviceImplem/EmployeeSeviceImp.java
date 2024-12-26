package com.wfm.workforcemanager.serviceImplem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wfm.workforcemanager.entity.Employee;
import com.wfm.workforcemanager.exeption.InvalidCridantial;
import com.wfm.workforcemanager.repository.EmployeeRepo;
import com.wfm.workforcemanager.service.EmployeeService;
@Service
public class EmployeeSeviceImp implements EmployeeService
{
	@Autowired
	EmployeeRepo employeeRepo;
	
	JavaMailSender javaMailSender = new JavaMailSenderImpl();
	@Autowired
	OtpSeviceimp otpSeviceimp;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@Override
	public Employee saveDetails(Employee employee) {
		employee.setPassword(encoder.encode(employee.getPassword()));
		return employeeRepo.save(employee);
	}

	@Override
	public Employee findEmployee(String value,String password) {
		Employee emp = employeeRepo.findEmployee(value, value);
		if(emp != null) {
			if(encoder.matches(password, emp.getPassword())) {
				return sentOTP(emp.getEmail());
			}
			return employeeRepo.findByEmail(emp.getEmail());
		}else {
			throw new InvalidCridantial();
		}
	}

	private Employee sentOTP(String email) {
		SimpleMailMessage mail=new SimpleMailMessage();
		int otp= (int)((Math.random()*1000000)+100000);
		mail.setFrom("michelrenish@111.com");
		otpSeviceimp.sentotp(otp,email);
		mail.setTo(email);
		mail.setSubject("Login OTP");
		mail.setText("Do not Share the OTP to anyone...\n OTP for login :"+otp);
		javaMailSender.send(mail);
		return null;
	}

}
