package com.example.demo.rest;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {

	public static void main(String[] args) {
		
		File csvFile = new File("C:\\pleiades\\2022-06\\workspace\\SpringBootProject\\csv\\test.csv");
		String url = "http://localhost:8080/account_upload";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		FileSystemResource resource = new FileSystemResource(csvFile);
		HttpEntity<FileSystemResource> entity = new HttpEntity<>(resource, headers);
		
		RestTemplate template = new RestTemplate();
//		Account account = template.getForObject(url, Account.class);
//		
//		System.out.println(account);
		ResponseEntity<String> response = template.postForEntity(url, entity, String.class);
		
		String responseBody = response.getBody();
		
		System.out.println("HTTP status: " + response.getStatusCode());
		System.out.println("HTTP response: " + responseBody);		
	}
}
