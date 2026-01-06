package com.cetnext.ecet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetnext.ecet.models.banner;
import com.cetnext.ecet.repository.bannerrepository;

@Service
public class bannerservice{
	@Autowired
	bannerrepository repo;
	public String sub(banner n) {
		repo.save(n);
		return "successfully completed";
	}
	public List<banner> fetch(){
		return repo.findAll();
		
	}
	
	
	
}
