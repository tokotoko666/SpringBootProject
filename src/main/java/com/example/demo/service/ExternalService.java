package com.example.demo.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExternalService {

	private static final String EXTERNAL_RESOURCE_URL = "https://qiita.com/api/v2/schema";
	
	private final RestTemplate restTemplate;
	
	public String getExternalResource() {
		ResponseEntity<String> response = restTemplate.exchange(EXTERNAL_RESOURCE_URL,HttpMethod.GET, null, String.class);
		return response.getBody();
	}
}
