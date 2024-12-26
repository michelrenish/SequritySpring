package com.jsp.SecurityPro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jsp.SecurityPro.filter.JwtFilter;
import com.jsp.SecurityPro.sevice.JwtService;
import com.jsp.SecurityPro.seviceImpli.UserRepodetailsService;

@EnableMethodSecurity
@Configuration
@EnableWebSecurity

public class SecurityConfig {
	
	@Autowired
	JwtFilter filter;
	
	@Bean
	UserDetailsService detailsService() {
//		UserDetails u1 = User.withUsername("Michel").password(pass.encode("12345")).roles("ADMIN").build();
//		UserDetails u2 = User.withUsername("br").password(pass.encode("67890")).roles("Mangager").build();
//		UserDetails u3 = User.withUsername("Clinton").password(pass.encode("1121")).roles("DBM").build();
//		return new InMemoryUserDetailsManager();
		return new UserRepodetailsService();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
//		return httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/hii").permitAll()
//				.and().authorizeHttpRequests().requestMatchers("/hi").hasRole("ADMIN").and()
//				.formLogin().and().build();
//	}
	@Bean
	SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
		return httpSecurity.csrf(t -> t.disable())	
				.authorizeHttpRequests(auth ->auth.requestMatchers("/login").permitAll()
						.requestMatchers("/hi").hasRole("ADMIN")
						.requestMatchers("/hii").permitAll()
						.requestMatchers("/hiii").hasRole("MANAGER")
						.requestMatchers("/save").hasRole("DBM"))
				.sessionManagement(sec->sec.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authenticationProvider(authenticationProvider()).addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(detailsService());
		return provider;
	}
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}

}
