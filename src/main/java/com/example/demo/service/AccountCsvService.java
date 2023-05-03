package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.csv.AccountCsvData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Service
public class AccountCsvService {

	@Autowired
	private CsvMapper csvMapper;
	
	@Autowired
	private CsvSchema csvSchema;
	
	public AccountCsvService(CsvMapper mapper, CsvSchema schema) {
		this.csvMapper = mapper;
		this.csvSchema = schema;
	}
	
	public CsvSchema getCsvHeader() {
		csvSchema = csvMapper.schemaFor(AccountCsvData.class).withHeader();
		return csvSchema;
	}
	
	public String writeCsvText(List<AccountCsvData> csvDataList, CsvSchema csvSchema) throws JsonProcessingException {
		return csvMapper.writer(csvSchema).writeValueAsString(csvDataList);
	}
}
