package com.cetnext.ecet.controller;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.cetnext.ecet.models.navbar;
import com.cetnext.ecet.service.navbarservice;
	@RestController
	@RequestMapping("/api/v1")
	public class navbarcontroller {
		@Autowired
		navbarservice service;
	@PostMapping("/add")

		public String add( @RequestBody navbar n) {
			
			return service.add(n);
			}
	@GetMapping("/getall")
	     public List <navbar> getall(){
	        return service.getall() ;
	}
	}

