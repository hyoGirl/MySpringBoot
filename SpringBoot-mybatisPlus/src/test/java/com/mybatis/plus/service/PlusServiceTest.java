package com.mybatis.plus.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.mybatis.plus.entity.Plus;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlusServiceTest {
	
	@Autowired
	private PlusService plusService;

	@Test
	public void testInsertPlus() {
		Plus plus=new Plus();
		
		plus.setName("DDD");
		plus.setAge(13);
		plus.setPwd("DDD");
		plus.setAddress("人民大道3号");
		plusService.insertPlus(plus);
		
	}

	@Test
	public void testGetPlus() {
		
		Plus plus = plusService.getPlus(10);
		System.out.println(plus.toString());
		
		
	}

	@Test
	public void testDeletePlus() {
		
		
	}

	@Test
	public void testUpdatePlus() {
		
		Plus plus=new Plus();
		
		plus.setId(10);
		plus.setAge(23);
		Integer count = plusService.updatePlus(plus);
		System.out.println(count);
		
		
	}

	@Test
	public void testFindAllPlusPage() {
		
		Page<Plus> pageInfo=new Page<>(1, 3);
		
		Page<Plus> page = plusService.findAllPlusPage(pageInfo);
		
		int total = page.getTotal();
		
		List<Plus> records = page.getRecords();
		
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", total);
        map.put("rows", records);
        
        System.out.println(map);
        
        
	}

}
