package com.wfm.workforcemanager.service;

import com.wfm.workforcemanager.entity.Employee;

public interface EmployeeService {
	public Employee saveDetails(Employee employee);
	public Employee findEmployee(String value,String password);
}
