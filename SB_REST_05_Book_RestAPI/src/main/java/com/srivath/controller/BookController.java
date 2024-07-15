package com.srivath.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srivath.binding.Book;

@RestController
public class BookController {

	@GetMapping(value = { "/getbook/{id}" }, produces = { "application/json", "application/xml" })
	public Book getBook(@PathVariable("id") Integer id) {
		System.out.println("req came to getBook, id = " + id);
		// logic to get book from database
		return new Book(1, "Ramayan", 1000.0);
	}

	@PostMapping(value = "/savebook", consumes = { "application/json", "application/xml" })
	public ResponseEntity<String> saveBook(@RequestBody Book book) {
		System.out.println("req came to saveBook, book = " + book);
		// logic to save book into database
		return new ResponseEntity<String>("Book saved sucessfully", HttpStatus.CREATED);
	}
}
