package com.cetnext.ecet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetnext.ecet.models.banner;
import com.cetnext.ecet.service.bannerservice;

@RestController
@RequestMapping("/api/v1")
public class bannercontroller {
	@Autowired
	bannerservice service;
	@PostMapping("/add1")
	public String sub(@RequestBody banner n ) {
		return service.sub(n);	
	}
	@GetMapping("/fetch")
	public List<banner> fetch(){
		return service.fetch();
		
	}
	
	

}
