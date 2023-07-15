package com.akash.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akash.model.Author;

@Service
public interface AuthorService {
	public List<Author> getAuthorList();
}
