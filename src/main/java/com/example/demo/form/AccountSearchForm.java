package com.example.demo.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountSearchForm {
	
	private String accountId;
	
	private String lastName;
	
	private String firstName;
	
	private Object age;

	private String positionCode;
	
	private String address;
	
}
