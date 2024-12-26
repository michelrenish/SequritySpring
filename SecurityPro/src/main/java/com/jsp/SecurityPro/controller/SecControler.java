package com.jsp.SecurityPro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.SecurityPro.dto.Auth;
import com.jsp.SecurityPro.entity.UserInfo;
import com.jsp.SecurityPro.sevice.JwtService;
import com.jsp.SecurityPro.seviceImpli.JwtServiceImp;
import com.jsp.SecurityPro.seviceImpli.UserServiceimp;

@RestController
public class SecControler {
	@Autowired
	UserServiceimp serviceimp;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtService jwtService;
	@Autowired
	JwtServiceImp imp;
	
	// Spring security dependency were add to get spring security web page
	// once we enter the password then only it's goes our own API's 
	// U want to change the user name and password in application.properties
	// spring.security.user.name="michel"
	// spring.security.user.password="123456" change like this.
	
	@GetMapping("login")
	String login(@RequestBody Auth req) {
		Authentication authentication =
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(),req.getPassword()));
		if(authentication.isAuthenticated()) {
		return jwtService.generateTocken(req.getUsername());
		}else {
			throw new UsernameNotFoundException("User Not fond ???"); 
		}
	}
	
	
	@GetMapping("hi")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")	//It's used to provide access to the role of admin only 
	public String welcome() {
		return "<h1>Wellcome to Spring security</h1>";
	}
	@GetMapping("hii")
	public String welcome1() {
		return "<h1>Wellcome to Spring Non-security</h1>";
	}
	@GetMapping("hiii")
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	public String welcome2() {
		return "<h1>Wellcome to Spring Non-non-security</h1>";
	}
	@PostMapping("save")
	@PreAuthorize("hasAuthority('ROLE_DBM')")
	public UserInfo save(@RequestBody UserInfo info) {
		return serviceimp.saveUser(info);
	}
}
