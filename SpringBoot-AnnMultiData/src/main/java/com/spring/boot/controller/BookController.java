package com.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.mapper.book.BookMapper;
import com.spring.boot.pojo.Book;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookMapper bookMapper;
	
	@GetMapping("/list")
	public List<Book> findAll(){
		
		return bookMapper.selectAll();
	}
}
