package com.akash.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.akash.model.Book;
import com.akash.repository.BookRepositry;
import com.akash.service.BookService;

@Component
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepositry bookRepositry;

	@Override
	public List<Book> getBookList() { // working fine
		return bookRepositry.findAll();
	}

	@Override
	public void addBook(Book book) { // working fine --> check bookCode

		if (bookRepositry.findById(book.getBookId()).isEmpty()) {

			bookRepositry.save(book);
		}
	}

	@Override
	public Book findById(int bookCode) {
		Optional<Book> optional = bookRepositry.findById(bookCode);
		return optional.get();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void updateBook(Book book, int bookCode) { // working fine but throw error when bookCode is not present
		Book existBook = bookRepositry.getById(bookCode);
		System.out.println(book.getBookName());
		existBook.setBookName(book.getBookName());
		existBook.setAuthor(book.getAuthor());
		bookRepositry.save(existBook);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteBook(int id) { // working fine but throw error when bookCode is not present

		Book book = bookRepositry.getOne(id);
		bookRepositry.delete(book);

	}

}
