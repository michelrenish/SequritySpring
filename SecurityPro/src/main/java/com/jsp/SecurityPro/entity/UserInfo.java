package com.jsp.SecurityPro.entity;



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
	private String role;
	private String password;
	public UserInfo(String userid, String username, String usermail, String role, String password) {
		super();
		this.userid = userid;
		this.username = username;
		this.usermail = usermail;
		this.role = role;
		this.password = password;
	}
	public UserInfo() {
		
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", username=" + username + ", usermail=" + usermail + ", role=" + role
				+ ", password=" + password + "]";
	}
}
