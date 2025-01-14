package com.jsp.SecurityPro.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jsp.SecurityPro.sevice.JwtService;
import com.jsp.SecurityPro.seviceImpli.UserRepodetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	JwtService jwtService;
	@Autowired
	UserRepodetailsService repodetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String auth = request.getHeader("Authorization");
		String token = null, username = null;
		if (auth != null && auth.startsWith("Bearer ")) {
			token = auth.substring(7);
			username = jwtService.extractUsername(token);
		}
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails u1 = repodetailsService.loadUserByUsername(username);
			if (jwtService.validate(token, u1)) {
				UsernamePasswordAuthenticationToken upauth = new UsernamePasswordAuthenticationToken(u1, null,
						u1.getAuthorities());
				upauth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(upauth);
			}
		}
		filterChain.doFilter(request, response);
	}
}
