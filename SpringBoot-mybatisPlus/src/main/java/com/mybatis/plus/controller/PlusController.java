package com.mybatis.plus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.plugins.Page;
import com.mybatis.plus.entity.Plus;
import com.mybatis.plus.service.PlusService;
import com.mybatis.plus.service.PlusServiceImpl;
import com.mybatis.plus.utils.PageInfoTable;


@RestController
public class PlusController {
		
	@Autowired
	private PlusService plusService;
	
	
	@PostMapping("/add")
	public void add(Plus plus){
		plusService.insertPlus(plus);
	}
	
	
	/**
	 * 测试获取一个
	 */
	
	@GetMapping("/get/{id}")
	public Plus getOne(@PathVariable("id")int id){
		
		return plusService.getPlus(id);
	}
	/**
	 * 测试分页
	 */
	@GetMapping("/page")
	public PageInfoTable<Plus> page(@RequestParam(defaultValue="1") Integer pageNumber,
			@RequestParam(defaultValue="6") Integer pageSize){
		Page<Plus> page=new Page<Plus>(pageNumber,pageSize);
		Page<Plus> result = plusService.findAllPlusPage(page);
		PageInfoTable<Plus> pageTable=new PageInfoTable<Plus>();
		pageTable.setRows(result.getRecords());
		pageTable.setTotal(result.getSize());
		return pageTable;
	}
}
