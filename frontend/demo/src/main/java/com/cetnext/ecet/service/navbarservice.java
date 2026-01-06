package com.cetnext.ecet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetnext.ecet.models.navbar;
import com.cetnext.ecet.repo.navbarrepository;



@Service
public class navbarservice {

    
	@Autowired
	navbarrepository repo;
	public String add(navbar n) {
		repo.save(n);
		return "Successfully complted";
		
		}
	public List<navbar> getall() {
		return repo.findAll();
		}
	}