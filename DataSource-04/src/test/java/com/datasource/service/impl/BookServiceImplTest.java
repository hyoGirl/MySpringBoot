package com.datasource.service.impl;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.datasource.App04;
import com.datasource.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App04.class)
public class BookServiceImplTest {
	
	@Autowired
	private BookService bookService;

	@Test
	public void testDeleteBookById() {
		
		
		bookService.deleteBookById(3l);
	}

}
