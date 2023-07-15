package com.akash.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akash.model.Book;
import com.akash.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBookList() {
		List<Book> books = bookService.getBookList();
		return ResponseEntity.of(Optional.of(books));
	}

	@PostMapping("/books")
	public ResponseEntity<Void> addBook(@RequestBody Book book) {
		try {
			bookService.addBook(book);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") int bookCode) {
		Book book = bookService.findById(bookCode);
		return book;
	}

	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBookById(@PathVariable("id") int bookCode) {
		try {
			bookService.deleteBook(bookCode);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/books/{id}")
	public ResponseEntity<Void> updateBook(@RequestBody Book book, @PathVariable("id") int bookCode) { // working fine
		try {
			bookService.updateBook(book, bookCode);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
