package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Account;
import com.example.demo.entity.PositionMst;
import com.example.demo.form.AccountForm;
import com.example.demo.service.AccountEditService;
import com.google.gson.Gson;


@Controller
@RequestMapping(value = "/account_edit")
public class AccountEditController {

	/** サービス */
	@Autowired
	private AccountEditService service;
	
	/** メッセージ */
	@Autowired
	private MessageSource message;
	
	/**
	 * 初期処理
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping
	public String init(@RequestParam("id") String id, Model model) {
		
		Account account = service.search(id);
		model.addAttribute("account", account);
		
		List<PositionMst> positionMstList = service.searchPositionMst();
		model.addAttribute("positionMstList", positionMstList);
		
		return "account_edit";
	}
	
	/**
	 * 更新処理
	 * 
	 * @param account
	 * @return
	 */
	@PostMapping
	@ResponseBody
	public String update(@RequestBody String param, BindingResult result) {
		
		Gson gson = new Gson();
		AccountForm accountForm = gson.fromJson(param, AccountForm.class);
		
		Account account = new Account();
		BeanUtils.copyProperties(accountForm, account);
		account.setId(Integer.parseInt(accountForm.getId()));
		account.setAge(Integer.parseInt(accountForm.getAge()));
		
		service.update(account);
		
		return gson.toJson(account);
	}
	
}
