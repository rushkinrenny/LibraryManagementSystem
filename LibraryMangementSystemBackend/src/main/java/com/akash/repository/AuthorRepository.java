package com.akash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
