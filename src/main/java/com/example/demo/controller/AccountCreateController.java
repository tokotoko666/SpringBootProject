package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.PositionMst;
import com.example.demo.form.AccountForm;
import com.example.demo.service.AccountCreateService;


@Controller
@RequestMapping(value = "/account_create")
public class AccountCreateController {

	/** サービス */
	@Autowired
	private AccountCreateService service;
	
	/** メッセージ */
	@Autowired
	private MessageSource message;
	
	@GetMapping
	public String init(@ModelAttribute AccountForm account, Model model) {
		List<PositionMst> positionMstList = service.searchPositionMst();
		model.addAttribute("positionMstList", positionMstList);	
		return "account_create";
	}

	/**
	 * 新規作成処理
	 * 
	 * @param account
	 * @return
	 */
	@PostMapping("/save")
	@ResponseBody
	public String create(@ModelAttribute AccountForm accountForm, Model model, BindingResult result) {
		
		service.create(accountForm);
		
		return "success";
	}
	
}
