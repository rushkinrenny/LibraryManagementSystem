package com.akash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akash.model.Author;
import com.akash.model.Book;
import com.akash.service.AuthorService;
import com.akash.service.BookService;

@Controller
public class BookController {
	@Autowired
	LoginController loginController;
	@Autowired
	AuthorService authorService;
	@Autowired
	BookService bookService;

	@Autowired
	Book book;

	@Autowired
	Author author;

	public Model getBookListAndUsername(Model model) {
		model.addAttribute("books", bookService.getBookList());
		model.addAttribute("username", loginController.getUsername());
		return model;
	}

	@RequestMapping("/showBooks")
	public String showAddBookPage(Model model) {
		model.addAttribute("username", loginController.getUsername());
		List<Author> authors = authorService.getAuthorList();
		model.addAttribute("authors", authors);
		return "addBook";
	}

	@PostMapping("/submitBook")
	public String addBook(@RequestParam("bookCode") int bookCode, @RequestParam("bookName") String bookName,
			@RequestParam("author") int authorId, Model model) {
		author.setAuthorId(authorId);
		book.setAuthor(author);
		book.setBookId(bookCode);
		book.setBookName(bookName);
		book.setBookAddedDate(bookService.getCurrentDate());
		bookService.addBook(book);
		model = getBookListAndUsername(model);
		return "home";
	}

	@RequestMapping("/deleteBook")
	public String deleteBook(@RequestParam("delete") int bookId, Model model) {
		bookService.deleteBook(bookId);
		model = getBookListAndUsername(model);
		return "home";
	}

	@RequestMapping("/editBook")
	public String editBook(@RequestParam("edit") int bookId, Model model) {
		model.addAttribute("username", loginController.getUsername());
		Book book = bookService.findById(bookId);
		List<Author> authors = authorService.getAuthorList();
		model.addAttribute("authors", authors);
		model.addAttribute("book", book);
		return "editBook";
	}

	@RequestMapping("/updateBook")
	public String updateBook(@RequestParam("bookCode") int bookCode, @RequestParam("bookName") String bookName,
			@RequestParam("author") int authorId, Model model) {
		author.setAuthorId(authorId);
		book.setAuthor(author);
		book.setBookId(bookCode);
		book.setBookName(bookName);
		book.setBookAddedDate(bookService.getCurrentDate());
		bookService.updateBook(book);
		model = getBookListAndUsername(model);
		return "home";
	}

}
