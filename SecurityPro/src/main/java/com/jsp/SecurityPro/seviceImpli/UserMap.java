package com.jsp.SecurityPro.seviceImpli;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jsp.SecurityPro.entity.UserInfo;

public class UserMap implements UserDetails {
	
	private String username;
	private String password;
	private List<GrantedAuthority> role;
	
	public UserMap(UserInfo info) { 
		username = info.getUsername();
		password = info.getPassword();
		role = Arrays.stream(info.getRole().split(" ")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return role;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

}
