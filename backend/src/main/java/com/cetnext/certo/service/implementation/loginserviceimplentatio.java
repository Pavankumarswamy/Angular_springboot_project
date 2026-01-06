package com.cetnext.certo.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cetnext.certo.models.login;
import com.cetnext.certo.repo.loginrepo;
import com.cetnext.certo.service.loginservice;

import jakarta.transaction.Transactional;

@Service
public class loginserviceimplentatio implements loginservice {

	@Autowired
	loginrepo repo;

	@Override
	public String add(login user) {
		try {
			if (!repo.findByEmail(user.getEmail()).isEmpty()) {
				// We can return a specific error string or throw exception.
				// Since controller returns String and frontend alerts it, a string is fine.
				// However, frontend checks for "added successfully" or similar?
				// Frontend code:
				// if (response) { ... }
				// Actually previous error handling in frontend might not distinguish unless 200
				// OK vs 400.
				// But backend returns 200 OK + String.
				// Ideally we should start using ResponseEntity but to keep consistency with
				// existing bad code style:
				return "Error: Email already exists!";
			}
			repo.save(user);
			return "User added successfully!";
		} catch (Exception e) {
			return "Error adding user: " + e.getMessage();
		}
	}

	@Override
	public List<login> getall() {
		return repo.findAll();
	}

	@Transactional
	@Override
	public String deleteid(String email) {
		try {
			List<login> users = repo.findByEmail(email);

			if (!users.isEmpty()) {
				repo.deleteAll(users);
				return "User with email " + email + " deleted successfully!";
			} else {
				return "User with email " + email + " not found!";
			}
		} catch (Exception e) {
			return "Error deleting user: " + e.getMessage();
		}
	}

	@Override
	public login getbyemail(String email) {
		try {
			List<login> users = repo.findByEmail(email);
			return users.isEmpty() ? null : users.get(0);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String update(login l, String email) {
		List<login> users = repo.findByEmail(email);
		if (!users.isEmpty()) {
			// Update the first one found, or maybe all? Updating first one for now to avoid
			// complexity or just update the one that acts as "primary"
			// Since we want to fix duplicates, maybe we should delete others?
			// For now let's just update the first one found.
			login user = users.get(0);
			user.setUsername(l.getUsername());
			user.setEmail(l.getEmail());
			user.setPassword(l.getPassword());
			user.setAcceptedTermsAndConditions(l.getAcceptedTermsAndConditions());
			user.setAddress(l.getAddress());
			repo.save(user);
			return "User updated successfully!";
		}
		return "User not found";
	}

	@Override
	public List<login> adddatas(List<login> users) {
		try {
			return repo.saveAll(users);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public login loginUser(String email, String password) {
		List<login> users = repo.findByEmail(email);
		for (login user : users) {
			if (user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
}
