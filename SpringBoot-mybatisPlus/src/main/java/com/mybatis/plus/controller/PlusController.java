package com.mybatis.plus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.plugins.Page;
import com.mybatis.plus.entity.Plus;
import com.mybatis.plus.service.PlusService;


@Controller
public class PlusController {
		
	@Autowired
	private PlusService plusService;
	
	
	@GetMapping("/add")
	@ResponseBody
	public void add(Plus plus){
		plusService.insertPlus(plus);
	}
	
	
	/**
	 * 测试获取一个
	 */
	
	@GetMapping("/get/{id}")
	@ResponseBody
	public Plus getOne(@PathVariable("id")int id){
		
//		return plusService.getPlus(id);
		return null;
		
	}
	/**
	 * 测试分页
	 */
	@GetMapping("/page")
	@ResponseBody
	public List page(@RequestParam(defaultValue="1") Integer pageNumber,
			@RequestParam(defaultValue="6") Integer pageSize){
//		Page page=new Page(pageNumber,pageSize);
//		plusService.findAllPlusPage(page);
//		return page.getRecords();
		
		return null;
		
	}
}
