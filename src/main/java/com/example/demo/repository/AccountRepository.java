package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>, AccountCustomRepository {

//	@Modifying
//	@Query("update Account set name = :name, age = :age, address = :address, comment = :comment where id = :id")
//	public void updateAccount(@Param("id") Integer id);
}
