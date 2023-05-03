package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "position_mst")
@Data
public class PositionMst {

	@Id
	private String code;
	
	private String name;
	
}
