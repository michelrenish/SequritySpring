package com.jsp.singupLogin.sevices;
import com.jsp.singupLogin.entity.UserInfo;

public interface UserService{

	UserInfo saveuser(UserInfo userInfo);
	public String login(String value,String password);
	
}