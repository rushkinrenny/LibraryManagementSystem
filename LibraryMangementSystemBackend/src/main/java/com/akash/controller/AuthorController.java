package com.akash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akash.model.Author;
import com.akash.service.AuthorService;

@RestController
public class AuthorController {
	@Autowired
	AuthorService authorService;

	@GetMapping("/authors")
	public List<Author> getAllAuthors() { // working fine
		return authorService.getAuthorList();
	}

	@PostMapping("/authors")
	public void addAuthor(@RequestBody Author author) { // working fine
		authorService.addAuthor(author);
	}

	@DeleteMapping("/authors/{id}")
	public void deleteAuthorById(@PathVariable("id") int authorId) { // working fine
		authorService.deleteAuthor(authorId);
	}

	@PutMapping("/authors/{id}")
	public void updateAuthor(@RequestBody Author author, @PathVariable("id") int authorCode) { // working fine
		authorService.updateAuthor(author, authorCode);
	}

	@GetMapping("/authors/{id}")
	public Author getAuthorById(@PathVariable("id") int authorId) { // working fine
		return authorService.findById(authorId);

	}
}
