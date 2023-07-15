package com.akash.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.akash.model.Author;
import com.akash.repository.AuthorRepository;
import com.akash.service.AuthorService;

@Component
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	@Override
	public List<Author> getAuthorList() {
		return authorRepository.findAll();
	}

	@Override
	public boolean addAuthor(Author author) {
		return authorRepository.save(author) == null;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void updateAuthor(Author author, int authorCode) {
		Author existAuthor = authorRepository.getById(authorCode);
		existAuthor.setAuthorName(author.getAuthorName());
		authorRepository.save(existAuthor);

	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteAuthor(int id) {
		Author author = authorRepository.getOne(id);
		authorRepository.delete(author);
	}

	@Override
	public Author findById(int authorId) {
		Optional<Author> optional = authorRepository.findById(authorId);
		try {

			return optional.get();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return optional.get();
		}

	}

}
