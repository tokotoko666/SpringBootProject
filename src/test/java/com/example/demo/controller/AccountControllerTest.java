package com.example.demo.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class AccountControllerTest {

	private final ByteArrayOutputStream stream = new ByteArrayOutputStream();
	
	@BeforeEach
	public void setupStream() {
		System.setOut(new PrintStream(stream));
	}
	
	@AfterEach
	public void cleanUpStream() {
		System.setOut(System.out);
	}
	
//	@Test
//	void testPrint() {
//		
//		AccountController controller = new AccountController();
//		controller.hoge("大谷", 29);
//		
//		String actual = stream.toString();
//		
//		assertEquals("名前：大谷\r\n年齢：29\r\n", actual);
//	}

}
