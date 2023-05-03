package com.example.demo.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Account;
import com.example.demo.form.AccountSearchForm;

public class AccountCustomRepositoryImpl implements AccountCustomRepository {

	private static final String LF = "\n";
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Account> multipleParamSearch(AccountSearchForm form) {

		Map<String, Object> param = new HashMap<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select a").append(LF);
		sql.append("from Account a").append(LF);
		
		sql.append("where").append(LF);
		sql.append("1 = 1").append(LF);
		
		if (StringUtils.isNotEmpty(form.getAccountId())) {
			sql.append("and account_id LIKE :accountid").append(LF);
			param.put("accountid", form.getAccountId() + "%");
		}
		
		if (StringUtils.isNotEmpty(form.getLastName())) {
			sql.append("and last_name LIKE :lastname").append(LF);
			param.put("lastname", form.getLastName() + "%");
		}

		if (StringUtils.isNotEmpty(form.getFirstName())) {
			sql.append("and first_name LIKE :firstname").append(LF);
			param.put("firstname", form.getFirstName() + "%");
		}
		
		if (ObjectUtils.isNotEmpty(form.getAge())) {
			sql.append("and age = :age").append(LF);
			param.put("age", form.getAge());
		}

		if (StringUtils.isNotEmpty(form.getPositionCode())) {
			sql.append("and position_code LIKE :positionCode").append(LF);
			param.put("positionCode", form.getPositionCode() + "%");
		}
		
		if (StringUtils.isNotEmpty(form.getAddress())) {
			sql.append("and address like :address").append(LF);
			param.put("address", "%" + form.getAddress() + "%");
		}
		
		sql.append("order by id");
		
		Query query = entityManager.createQuery(sql.toString(), Account.class);
		param.forEach((k, v) -> query.setParameter(k, v));
		
		@SuppressWarnings("unchecked")
		List<Account> accountList = query.getResultList();
		
		return accountList;
	}

}
