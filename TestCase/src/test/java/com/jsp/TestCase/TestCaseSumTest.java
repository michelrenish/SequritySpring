package com.jsp.TestCase;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestCaseSumTest {
	
	TestCaseSum caseSum = new TestCaseSum();
	@Test
	void test() {
		Assertions.assertEquals(40, caseSum.sum(200,20));
	}
	@Test
	void test1() {
		Assertions.assertEquals(50, caseSum.sum(30,20));
	}
	@Test
	void test2() {
		Assertions.assertEquals(40, caseSum.sum(10,20));
	}
	@Test
	void test3() {
		Assertions.assertEquals(20, caseSum.sum(0,20));
	}
	@Test
	void test4() {
		Assertions.assertEquals(400, caseSum.sum(200,20));
	}

}
