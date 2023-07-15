package com.akash.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.akash.constant.Constant;
import com.akash.model.Author;
import com.akash.service.AuthorService;

@Component
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<Author> getAuthorList() {
		ResponseEntity<List> authorListResponse = restTemplate.getForEntity(Constant.AUTHOR_URI, List.class);
		return authorListResponse.getBody();
	}

}
