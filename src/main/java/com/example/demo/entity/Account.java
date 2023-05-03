package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	
	@NotEmpty(message = "アカウントIDに空白はダメ")
	@Column(name = "account_id")
	private String accountId;
	
	@NotEmpty(message = "名前に空白はダメ")
	@Column(name = "last_name")
	private String lastName;

	@NotEmpty(message = "名前に空白はダメ")
	@Column(name = "first_name")
	private String firstName;
	
	private Integer age;

	@Column(name = "position_code")
	private String positionCode;
	
	@NotBlank(message = "住所に空白はダメ")
	private String address;
	
	private String comment;
	
}
