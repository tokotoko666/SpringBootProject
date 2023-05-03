package com.example.demo.csv;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonPropertyOrder({"アカウントID", "苗字", "名前", "年齢", "ポジション", "住所", "コメント"})
@AllArgsConstructor
public class AccountCsvData {

	@JsonProperty("アカウントID")
	private String accountId;
	
	@JsonProperty("苗字")
	private String lastName;
	
	@JsonProperty("名前")
	private String firstName;
	
	@JsonProperty("年齢")
	private String age;
	
	@JsonProperty("ポジション")
	private String position;
	
	@JsonProperty("住所")
	private String address;
	
	@JsonProperty("コメント")
	private String comment;
	
}
