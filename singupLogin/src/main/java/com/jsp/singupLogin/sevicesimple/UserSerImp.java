package com.jsp.singupLogin.sevicesimple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jsp.singupLogin.entity.UserInfo;
import com.jsp.singupLogin.exeption.InvalidCridantial;
import com.jsp.singupLogin.repository.UserRepo;
import com.jsp.singupLogin.sevices.UserService;

@Service
public class UserSerImp implements UserService{
	@Autowired
	private UserRepo repo;
	@Autowired
	OtpSeviceimp otpSeviceimp;
	
	Logger logger = LoggerFactory.getLogger(UserSerImp.class);
	
	BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
	
	@Autowired
	JavaMailSender mailSender;
	
	public String sentOtp(String email) {
		SimpleMailMessage mail = new SimpleMailMessage();
		int otp= (int)((Math.random()*1000000)+100000);
		mail.setFrom("michelrenish@111.com");
		otpSeviceimp.sentotp(otp,email);
		mail.setTo(email);
		mail.setSubject("Login OTP");
		mail.setText("Do not Share the OTP to anyone...\n OTP for login :"+otp);
		mailSender.send(mail);
		logger.info("OTP Sent to your mail");
		return "OTP sent throughs Your Mail";
	}
	public UserSerImp(UserRepo repo) {
		super();
		this.repo = repo;
	}


	@Override
	public UserInfo saveuser(UserInfo userInfo) {
		userInfo.setPassword(pass.encode(userInfo.getPassword()));
		logger.info("User Details are saved");
		return repo.save(userInfo);
	}


	@Override
	public String login(String value, String password) {
		UserInfo u1 = repo.login(value, value);
		if(u1 != null) {
			if(pass.matches(password,u1.getPassword())) {
			return sentOtp(u1.getUsermail());
			}
			else {
				logger.error("Invalid Password");
				throw new InvalidCridantial();
			}
		}
		else {
			logger.error("Invalid User ID or Email");
			throw new InvalidCridantial();
		}
	}
	
}