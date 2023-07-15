package com.akash.service;

import org.springframework.stereotype.Service;

import com.akash.model.Librarian;

@Service
public interface LibrarianService {
	public Librarian findByUsernameAndPassword(String username, String password);
}
