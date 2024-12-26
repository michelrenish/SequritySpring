package com.wfm.workforcemanager.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
	@Id 
	private String eid;
	private String ename;
	private String password;
	@Column(unique = true)
	private String email;
	private String role;
	private String mid;
	@OneToMany
	private List<Project> projects;
	@OneToOne
	private Address address;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Employee(String eid, String ename, String password, String email, String role, String mid,
			List<Project> projects, Address address) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.password = password;
		this.email = email;
		this.role = role;
		this.mid = mid;
		this.projects = projects;
		this.address = address;
	}
	public Employee() {
		
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", password=" + password + ", email=" + email + ", role="
				+ role + ", mid=" + mid + ", projects=" + projects + ", address=" + address + "]";
	}
	
}
