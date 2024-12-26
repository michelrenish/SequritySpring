package com.jsp.singupLogin.exeption;

public class InvalidOTP extends RuntimeException {
	public InvalidOTP() {
		super("Invalid OTP");
	}
}
