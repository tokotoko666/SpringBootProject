package com.example.demo.controller;

import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountUploadService;
import com.opencsv.CSVReader;

@Controller
@RequestMapping("/account_upload")
public class AccountUploadController {
	
	@Autowired
	private AccountUploadService uploadService;
	
	@GetMapping
	public String upload(Model model) {
		return "account_upload";
	}
	
	@PostMapping
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
		
		
		try (Reader reader = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);
			CSVReader csvReader = new CSVReader(reader)) {
			String []line;
			
			while ((line = csvReader.readNext()) != null) {
				
				// TODO チェック処理
				
				for (int i = 1; i <= line.length; i++) {
					Account account = new Account();
					account.setLastName(line[i++]);
					account.setFirstName(line[i++]);
					account.setAge(Integer.parseInt(line[i++]));
					
					String positionName = StringUtils.trim(line[i++]);
					String positionCode = uploadService.searchPositionCode(positionName);
					account.setPositionCode(positionCode);
					
					account.setAddress(line[i++]);
					account.setComment(line[i++]);
					
					uploadService.save(account);
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("upload success");
		
	}
}
