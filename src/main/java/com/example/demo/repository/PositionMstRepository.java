package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.PositionMst;

@Repository
public interface PositionMstRepository extends JpaRepository<PositionMst, String> {
	
	public PositionMst findByName(String name);
}
