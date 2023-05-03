package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.PositionMst;
import com.example.demo.form.AccountSearchForm;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.PositionMstRepository;

@Service
public class AccountService {

	/** アカウントリポジトリ */
	@Autowired
	private AccountRepository accountRepo;
	
	/** ポジションマスタリポジトリ */
	@Autowired
	private PositionMstRepository positionMstRepository;
	
	/**
	 * 検索処理
	 * 
	 * @param form
	 * @return
	 */
	public List<Account> search(AccountSearchForm form) {
		List<Account> accountList = accountRepo.multipleParamSearch(form);
		return accountList;
	}
//	
//	public List<Account> printByGet(Account account) {
//		
//		System.out.println("ゲットから");
//		
////		List<String> accountList = userRepo.findAll().stream().filter(e -> e.getAge() > 25).map(Account::getName)
////		.collect(Collectors.toList());
//		
//		List<Account> accountList = accountRepo.findAll().stream().filter(e -> e.getAge() > 25).collect(Collectors.toList());
//		accountList.forEach(System.out::println);
//		return accountList;
//	}

	public void update(Account account) {
		accountRepo.save(account);
	}

	public List<PositionMst> searchPositionMst() {
		return  positionMstRepository.findAll();
	}
	
}
