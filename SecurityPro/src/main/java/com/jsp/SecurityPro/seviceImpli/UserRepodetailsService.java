package com.jsp.SecurityPro.seviceImpli;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jsp.SecurityPro.entity.UserInfo;
import com.jsp.SecurityPro.repository.UserInfoRepo;

@Service
public class UserRepodetailsService implements UserDetailsService {
	
	@Autowired
	UserInfoRepo infoRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo>info = Optional.ofNullable(infoRepo.findByUsername(username));
		return info.map(UserMap::new).orElseThrow(()-> new UsernameNotFoundException("User Name Not found"));
	}

}
