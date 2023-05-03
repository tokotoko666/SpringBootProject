package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Account;
import com.example.demo.entity.PositionMst;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.PositionMstRepository;

@Service
public class AccountEditService {

	/** アカウントリポジトリ */
	@Autowired
	private AccountRepository accountRepo;
	
	/** ポジションマスタリポジトリ */
	@Autowired
	private PositionMstRepository positionMstRepository;

	/**
	 * アカウントの検索処理
	 * 
	 * @param id
	 * @return
	 */
	public Account search(String id) {
		return accountRepo.findById(Integer.parseInt(id)).get();
	}

	/**
	 * ポジションマスタの検索処理
	 * 
	 * @return
	 */
	public List<PositionMst> searchPositionMst() {
		return  positionMstRepository.findAll();
	}
	
	/**
	 * アカウントの更新処理
	 * 
	 * @param account
	 */
	@Transactional
	public void update(Account account) {
		accountRepo.save(account);
	}

}
