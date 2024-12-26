package com.jsp.singupLogin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserInfo {
	@Id
	private String userid;
	private String username;
	@Column(unique = true)
	private String usermail;
	private long phno;
	private String password;
	
	public UserInfo(String userid, String username, String usermail, long phno, String password) {
		this.userid = userid;
		this.username = username;
		this.usermail = usermail;
		this.phno = phno;
		this.password = password;
	}

	public UserInfo() {
		super();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", username=" + username + ", usermail=" + usermail + ", phno=" + phno
				+ ", password=" + password + "]";
	}
	
	
	
}
