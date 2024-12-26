package com.wfm.workforcemanager.exeption;

public class InvalidOTP extends RuntimeException {
	public InvalidOTP() {
		super("Invalid OTP");
	}
}
