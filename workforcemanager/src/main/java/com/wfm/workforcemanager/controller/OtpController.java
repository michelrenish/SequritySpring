package com.wfm.workforcemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.wfm.workforcemanager.entity.Employee;
import com.wfm.workforcemanager.serviceImplem.OtpSeviceimp;


@RestController
public class OtpController {
	@Autowired
	OtpSeviceimp otpSeviceimp;
	
	@GetMapping("validation")
	public ResponseEntity<Employee> validation(@RequestHeader int otp) {
		Employee employee = otpSeviceimp.validation(otp);
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
}
