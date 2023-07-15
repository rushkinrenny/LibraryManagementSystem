package com.akash.service.impl;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.akash.constant.Constant;
import com.akash.model.Book;
import com.akash.service.BookService;

@Component
public class BookServiceImpl implements BookService {
	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<Book> getBookList() {
		ResponseEntity<List> bookListResponse = restTemplate.getForEntity(Constant.BOOK_URI, List.class);
		return bookListResponse.getBody();
	}

	@Override
	public String getCurrentDate() {
		DateFormat Date = DateFormat.getDateInstance();
		Calendar cals = Calendar.getInstance();
		String currentDate = Date.format(cals.getTime());
		return currentDate;
	}

	@Override
	public void addBook(Book book) {
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Book> requestEntity = new HttpEntity<Book>(book, headers);

		ResponseEntity<Book> response = restTemplate.exchange(Constant.BOOK_URI, HttpMethod.POST, requestEntity,
				Book.class);

	}

	@Override
	public void deleteBook(int bookId) {
		// TODO Auto-generated method stub
		restTemplate.delete(Constant.BOOK_URI + "/" + bookId);
	}

	@Override
	public Book findById(int bookId) {
		ResponseEntity<Book> bookResponse = restTemplate.getForEntity(Constant.BOOK_URI + "/" + bookId, Book.class);

		return bookResponse.getBody();
	}

	@Override
	public void updateBook(Book book) {
		HttpHeaders headers = new HttpHeaders();

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Book> requestEntity = new HttpEntity<Book>(book, headers);

		ResponseEntity<Book> response = restTemplate.exchange(Constant.BOOK_URI + "/" + book.getBookId(),
				HttpMethod.PUT, requestEntity, Book.class);

	}

}
