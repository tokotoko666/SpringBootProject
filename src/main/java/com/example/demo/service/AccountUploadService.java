package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.PositionMst;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.PositionMstRepository;

@Service
public class AccountUploadService {

	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private PositionMstRepository positionMstRepo;
	
	/**
	 * @param positionName
	 * @return
	 */
	public String searchPositionCode(String positionName) {
		PositionMst positionMst = positionMstRepo.findByName(positionName);
		return positionMst.getCode();
	}
	
	/**
	 * @param account
	 */
	public void save(Account account) {
		accountRepo.save(account);
	}
}
