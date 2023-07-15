package com.akash.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Author {
	@Id
	@Column(name = "author_id")
	private int authorId;
	@Column(name = "author_name")
	private String authorName;

	@JsonIgnore
	@OneToMany(mappedBy = "author")
	private List<Book> books;

	public Author() {
		super();
	}

	public Author(int authorId, String authorName, List<Book> books) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.books = books;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
