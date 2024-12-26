package com.jsp.singupLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.singupLogin.entity.UserInfo;
import com.jsp.singupLogin.sevicesimple.OtpSeviceimp;

@RestController
public class OtpController {
	@Autowired
	OtpSeviceimp otpSeviceimp;
	
	@GetMapping("validation")
	public ResponseEntity<UserInfo> validation(@RequestHeader int otp) {
		UserInfo user = otpSeviceimp.validation(otp);
		return new ResponseEntity<UserInfo>(user,HttpStatus.OK);
	}
	
}
