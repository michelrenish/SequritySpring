package com.jsp.singupLogin.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jsp.singupLogin.entity.UserInfo;
import com.jsp.singupLogin.sevicesimple.UserSerImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class Usercontroller {
	@Autowired
	private UserSerImp userSerImp;

	@PostMapping("singup")
	public ResponseEntity<UserInfo> savedetails(@RequestBody UserInfo userInfo) {
		return new ResponseEntity<UserInfo>(userSerImp.saveuser(userInfo),HttpStatus.ACCEPTED);
	}
	@GetMapping("login")
	public ResponseEntity<String> login(@RequestHeader String value,@RequestHeader String password) {
		userSerImp.login(value, password);
		return new ResponseEntity<String>("OTP sent throughs Your Mail",HttpStatus.OK);
	}	
}
