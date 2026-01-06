package com.cetnext.ecet.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cetnext.ecet.models.navbar;
@Repository
public interface navbarrepository extends JpaRepository<navbar, Integer> {
	
	

}
