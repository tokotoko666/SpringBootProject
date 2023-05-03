package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="password")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Password {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	
	@NotEmpty(message = "アカウントIDに空白はダメ")
	@Column(name = "account_id")
	private String accountId;
	
	@NotEmpty(message = "パスワードに空白はダメ")
	@Column(name = "password")
	private String password;
	
}
