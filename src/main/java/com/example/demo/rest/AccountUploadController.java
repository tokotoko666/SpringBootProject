package com.example.demo.rest;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Account;
import com.google.gson.Gson;
import com.opencsv.CSVReader;

//@RestController
//@RequestMapping("/account_upload")
public class AccountUploadController {
	
	@GetMapping
	public String upload() {
		Account account = new Account(99, "accountId", "lastName", "firstName", 40, "positionCode", "address", "comment");
		
		Gson gson = new Gson();
		
		return gson.toJson(account); 
	}
	
	@PostMapping
	public ResponseEntity<String> upload(@RequestBody MultipartFile file) {
		
		try (Reader reader = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);
			CSVReader csvReader = new CSVReader(reader)) {
			String []line;
			
			while ((line = csvReader.readNext()) != null) {
				System.out.println(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("upload success");
		
	}
}
