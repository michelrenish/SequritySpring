package com.wfm.workforcemanager.serviceImplem;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wfm.workforcemanager.entity.Employee;
import com.wfm.workforcemanager.repository.EmployeeRepo;

@Service
public class UserRepodetailsService implements UserDetailsService {

	@Autowired
	EmployeeRepo employeeRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> emp = Optional.ofNullable(employeeRepo.findByUname(username));
		return emp.map(EmployeMap::new).orElseThrow(()-> new UsernameNotFoundException("Not found"));
		
	}

}
