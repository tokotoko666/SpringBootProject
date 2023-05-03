package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Example;
import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/example")
public class ExampleController {

	@GetMapping
	public String example(Model model) {
	  List<Example> accounts = Arrays.asList(
	  new Example("John", "123 Main St."),
	  new Example("Jane", "456 Elm St.")
	  );
	  
	  Gson gson = new Gson();
	  String result = gson.toJson(accounts);
	  
	  
	  model.addAttribute("accounts", result);
	  return "example";
	}
	
}
