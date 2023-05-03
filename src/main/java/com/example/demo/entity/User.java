package com.example.demo.entity;


import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@NotBlank(message="空白はダメ")
	private String name;
	
	private int age;
	
	@NotBlank(message="住所に空白はダメ")
	private String address;
	
	private String comment;
	
	private boolean select;
	
}
