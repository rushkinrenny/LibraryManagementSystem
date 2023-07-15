package com.akash.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.akash.model.Book;

@Service
public interface BookService {

	public List<Book> getBookList();

	public String getCurrentDate();

	public void addBook(Book book);

	public void deleteBook(int bookId);

	public Book findById(int bookCode);

	public void updateBook(Book book);
}
