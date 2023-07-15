package com.akash.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Librarian {
	private String email;
	private String username;
	private String password;

	private List<Book> books;

	public Librarian() {
		super();
	}

	public Librarian(String email, String username, String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Librarian [email=" + email + ", username=" + username + ", password=" + password + ", books=" + books
				+ "]";
	}

}
