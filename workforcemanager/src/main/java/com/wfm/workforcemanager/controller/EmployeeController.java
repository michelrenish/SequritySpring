package com.wfm.workforcemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.wfm.workforcemanager.entity.Employee;
import com.wfm.workforcemanager.serviceImplem.EmployeeSeviceImp;


@RestController
public class EmployeeController {
	@Autowired
	private EmployeeSeviceImp employeeSeviceImp;

	@PostMapping("singup")
	public ResponseEntity<Employee> savedetails(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeSeviceImp.saveDetails(employee),HttpStatus.ACCEPTED);
	}
	@GetMapping("login")
	public ResponseEntity<String> login(@RequestHeader String value,@RequestHeader String password) {
		employeeSeviceImp.findEmployee(value, password);
		return new ResponseEntity<String>("OTP sent throughs Your Mail",HttpStatus.OK);
	}	
}
