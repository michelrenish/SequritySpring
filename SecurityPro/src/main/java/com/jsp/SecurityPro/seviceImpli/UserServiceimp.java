package com.jsp.SecurityPro.seviceImpli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.SecurityPro.entity.UserInfo;
import com.jsp.SecurityPro.repository.UserInfoRepo;
import com.jsp.SecurityPro.sevice.UserInfoService;

@Service
public class UserServiceimp implements UserInfoService {
	
	@Autowired
	UserInfoRepo infoRepo;
	
	@Override
	public UserInfo saveUser(UserInfo userInfo) {
		return infoRepo.save(userInfo);
	}
}
