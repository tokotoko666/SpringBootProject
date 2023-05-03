package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Password;
import com.example.demo.entity.PositionMst;
import com.example.demo.form.AccountForm;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.PasswordRepository;
import com.example.demo.repository.PositionMstRepository;
import com.example.demo.util.StringUtil;

@Service
public class AccountCreateService {

	/** アカウントリポジトリ */
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private PasswordRepository passwordRepo;
 	
	/** ポジションマスタリポジトリ */
	@Autowired
	private PositionMstRepository positionMstRepository;

	/**
	 * ポジションマスタの検索処理
	 * 
	 * @return
	 */
	public List<PositionMst> searchPositionMst() {
		return  positionMstRepository.findAll();
	}
	
	/**
	 * アカウントとパスワードの新規作成処理
	 * 
	 * @param accountForm
	 */
	@Transactional
	public void create(AccountForm accountForm) {
		
		Account account = new Account();
		BeanUtils.copyProperties(accountForm, account);
		account.setAge(Integer.parseInt(accountForm.getAge()));
		accountRepo.save(account);
		
		Password password = new Password();
		password.setAccountId(accountForm.getAccountId());
		password.setPassword(StringUtil.toMd5(accountForm.getPassword()));
		passwordRepo.save(password);
	}

}
