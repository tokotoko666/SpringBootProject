package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.demo.filter.LogFilter;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@EnableWebMvc
@Slf4j
class DemoControllerTest {

	MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	
	@Autowired
	LogFilter logFilter;
	
	@BeforeEach
	void berforeEach() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilter(logFilter, "/*").build();
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("テスト終了");
		logFilter.destroy();
	}
	
	@Test
	void testHello() throws Exception {
		mockMvc.perform(get("/hello"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.status").value("success"))
			.andExpect(jsonPath("$.message").value("request succeeded."))
			.andExpect(jsonPath("$.data").value("hello"));
	}
	
	@Test
	void divideSuccess() throws Exception {
		mockMvc.perform(get("/divide/10/3"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.status").value("success"))
			.andExpect(jsonPath("$.message").value("request succeeded."))
			.andExpect(jsonPath("data").value("3.33"));
	}
	
	@Test
	void divideInvalidParameter() throws Exception {
	    mockMvc
        .perform(get("/divide/10/aaa"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.status").value("failure"))
        .andExpect(jsonPath("$.message").value("divide.num2:must match \"[0-9]*\"")); 
	}

	@Test
	void divideZeroError() throws Exception {
		mockMvc.perform(get("/divide/10/0"))
			.andExpect(status().is5xxServerError())
			.andExpect(jsonPath("$.status").value("failure"))
			.andExpect(jsonPath("$.message").value("error has occurred."));
	}
	
}
