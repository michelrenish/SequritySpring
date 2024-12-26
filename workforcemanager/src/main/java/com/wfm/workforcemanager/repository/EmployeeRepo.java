package com.wfm.workforcemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wfm.workforcemanager.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, String> {
	
	@Query(nativeQuery = true, value = "select * from Employee where uid=?1 or email=?2 ")
	public Employee findEmployee(String uid,String email);
	
	public Employee findByEmail(String email);

	public Employee findByUname(String uname);
}
