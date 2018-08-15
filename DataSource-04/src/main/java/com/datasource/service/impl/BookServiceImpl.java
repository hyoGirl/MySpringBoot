package com.datasource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datasource.config.DataSourceContextHolder;
import com.datasource.dao.BookMapper;
import com.datasource.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	
	
	@Autowired
	private BookMapper bookMapper;
	
	String databasename="databook";

	@Override
	public void deleteBookById(Long id) {
		
		try {
			System.out.println(DataSourceContextHolder.getDBType());
			
			bookMapper.deleteBookById(id);
			
		} catch (Exception e) {
			
			System.err.println("执行切换数据库操作");
			e.printStackTrace();
//			DataSourceContextHolder.setDBType(databasename);
//			
//			bookMapper.deleteBookById(id);
			
		}
	}

}
