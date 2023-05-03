package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.csv.AccountCsvData;
import com.example.demo.entity.Account;
import com.example.demo.entity.PositionMst;
import com.example.demo.form.AccountSearchForm;
import com.example.demo.helper.DownloadHelper;
import com.example.demo.service.AccountCsvService;
import com.example.demo.service.AccountService;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.google.gson.Gson;


@Controller
@RequestMapping(value = "/account")
public class AccountController {

	/** サービス */
	@Autowired
	private AccountService service;
	
	/** メッセージ */
	@Autowired
	private MessageSource message;
	
	@Autowired
	DownloadHelper  downloadHelper;
	
	@Autowired
	private AccountCsvService csvService;
	
	/**
	 * 初期処理
	 * 
	 * @param form
	 * @param model
	 * @return
	 */
	@GetMapping
	public String init(@ModelAttribute AccountSearchForm form, Model model) {
		List<PositionMst> positionMstList = service.searchPositionMst();
		model.addAttribute("positionMstList", positionMstList);
		return "account";
	}
	
	/**
	 * 検索処理
	 * 
	 * @param param
	 * @param model
	 * @return
	 */
	@PostMapping
	@ResponseBody
	public String search(@RequestBody String param, Model model) {	
		
		Gson gson = new Gson();
		AccountSearchForm form = gson.fromJson(param, AccountSearchForm.class);
		
		List<Account> accountList = service.search(form);
		
//		if (accountList.isEmpty()) {
//			// JSONで返しているのでメッセージが出ない…
//			model.addAttribute("message", message.getMessage("no_data", null, Locale.getDefault()));
//		}

		return gson.toJson(accountList);
		
	}
	
	/**
	 * CSV出力処理
	 * 
	 * @param param
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@PostMapping("download")
	@ResponseBody
	public ResponseEntity<byte[]> download(@RequestBody String param, Model model) throws IOException {
		
		Gson gson = new Gson();
		AccountSearchForm form = gson.fromJson(param, AccountSearchForm.class);
		List<Account> accountList = service.search(form);
		
		List<AccountCsvData> csvDataList = accountList.stream().map(e -> new AccountCsvData(e.getAccountId(), e.getLastName(),
				e.getFirstName(), String.valueOf(e.getAge()), e.getPositionCode(), e.getAddress(), e.getComment()))
				.collect(Collectors.toList());
		
		HttpHeaders header = new HttpHeaders();
		downloadHelper.addContentDisposition(header, "account.csv");
		
		CsvSchema csvSchema = csvService.getCsvHeader();
		return new ResponseEntity<>(csvService.writeCsvText(csvDataList, csvSchema).getBytes("UTF-8"), header, HttpStatus.OK);
	}
}
