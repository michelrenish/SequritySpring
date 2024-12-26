package com.wfm.workforcemanager.serviceImplem;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.wfm.workforcemanager.entity.Employee;


public class EmployeMap implements UserDetails {

	private String username;
	private String password;
	private List<GrantedAuthority> role;
	
	public EmployeMap(Employee employee) { 
		username = employee.getEname();
		password = employee.getPassword();
		role = Arrays.stream(employee.getRole().split(" ")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return role;
	}

}
