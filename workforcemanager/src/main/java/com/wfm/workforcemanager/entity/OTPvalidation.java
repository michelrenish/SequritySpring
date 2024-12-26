package com.wfm.workforcemanager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OTPvalidation {
	
	private int otp;
	@Id
	private String usermail;



	public OTPvalidation(int otp, String usermail) {
		super();
		this.otp = otp;
		this.usermail = usermail;
	}
	public OTPvalidation() {
		super();
	}

	public String getUsermail() {
		return usermail;
	}

	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}

	public int getOtp() {
		return otp;
	}

	public void setOtp(int otp) {
		this.otp = otp;
	}

	@Override
	public String toString() {
		return "OTPvalidation [otp=" + otp + ", usermail=" + usermail + "]";
	}
	
}
