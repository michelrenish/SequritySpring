package com.jsp.TestCase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestCaseApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(TestCaseApplication.class, args);
		TestCaseSum caseSum = new TestCaseSum();
		System.out.println(caseSum.sum(10,20)); 
	}

}
