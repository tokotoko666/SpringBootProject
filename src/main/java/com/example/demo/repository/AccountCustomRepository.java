package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;
import com.example.demo.form.AccountSearchForm;

@Repository
public interface AccountCustomRepository {

	public List<Account> multipleParamSearch(AccountSearchForm form);
}
