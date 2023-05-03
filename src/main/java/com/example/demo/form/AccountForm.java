package com.example.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountForm {
	
	private String id;
	
	private String accountId;
	
	private String password;
	
	@NotEmpty(message = "名前に空白はダメ")
	private String lastName;

	@NotEmpty(message = "名前に空白はダメ")
	private String firstName;
	
	private String age;

	private String positionCode;
	
	@NotBlank(message = "住所に空白はダメ")
	private String address;
	
	private String comment;
	
}
