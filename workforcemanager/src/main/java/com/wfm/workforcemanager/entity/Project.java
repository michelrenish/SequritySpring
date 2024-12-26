package com.wfm.workforcemanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String pname;
	private String mid;
	
	public Project(int pid, String pname, String mid) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.mid = mid;
	}
	
	public Project() {
		super();
		}
	

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Project [pid=" + pid + ", pname=" + pname + ", mid=" + mid + "]";
	}
	
}
