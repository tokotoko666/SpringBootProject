package com.example.demo.controller;

import java.math.BigDecimal;

import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CommonResponse;
import com.example.demo.service.DemoService;
import com.example.demo.service.ExternalService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Validated
public class DemoController {

	private final DemoService demoService;
	private final ExternalService externalService;
	
	@SuppressWarnings("unchecked")
	@GetMapping("/hello")
	public <T> CommonResponse<T> hello() {
		String data = demoService.hello();
		return (CommonResponse<T>) CommonResponse.builder().data(data).build();
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/divide/{num1}/{num2}")
	public <T> CommonResponse<T> divide(
			@PathVariable @Pattern(regexp = "[0-9]*") String num1,
			@PathVariable @Pattern(regexp = "[0-9]*") String num2) {
		
		BigDecimal data = demoService.divide(new BigDecimal(num1), new BigDecimal(num2));
		return (CommonResponse<T>) CommonResponse.builder().data(data).build();
	}

}
