package com.akash.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.akash.model.Librarian;
import com.akash.repository.LibrarianRepository;
import com.akash.service.LibrarianService;

@Component
public class LibrarianServiceImpl implements LibrarianService {
	@Autowired
	LibrarianRepository librarianRepository;

	@Override
	public Librarian findByUsernameAndPassword(String username, String password) {
		Librarian librarian = librarianRepository.findByUsernameAndPassword(username, password);
		return librarian;
	}

}
