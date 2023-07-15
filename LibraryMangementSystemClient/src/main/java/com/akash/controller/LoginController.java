package com.akash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.akash.constant.Constant;
import com.akash.model.Book;
import com.akash.model.Librarian;
import com.akash.service.BookService;

@Controller
public class LoginController {
	private String username;

	@Autowired
	BookService bookService;

	public String getUsername() {
		return username;
	}

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	Librarian librarian;

	@RequestMapping("/")
	public String showLogin() {
		return "login";
	}

	@PostMapping("/home")
	public String validLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {
		this.username = username;
		librarian.setUsername(username);
		librarian.setPassword(password);
		String uri = Constant.LIBRARIAN_URI + "/" + username + "/" + password;
		ResponseEntity<Librarian> response = restTemplate.getForEntity(uri, Librarian.class);
		Librarian isValidLibrarian = response.getBody();

		System.out.println(isValidLibrarian);
		if (isValidLibrarian == null) {
			return "error";
		} else {
			model.addAttribute("username", isValidLibrarian.getUsername());
			List<Book> books = bookService.getBookList();
			model.addAttribute("books", books);
			return "home";
		}
	}
}
