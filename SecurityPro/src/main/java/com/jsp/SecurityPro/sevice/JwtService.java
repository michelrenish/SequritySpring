package com.jsp.SecurityPro.sevice;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
	String generateTocken(String username);

	String extractUsername(String token);

	boolean validate(String token, UserDetails u1);
}
