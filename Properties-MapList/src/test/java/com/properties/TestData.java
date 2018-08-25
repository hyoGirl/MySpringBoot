package com.properties;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.properties.PropertiesApp;
import com.spring.properties.config.DataConfig;
import com.spring.properties.config.DataModel;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=PropertiesApp.class)
public class TestData {
	
	
	@Autowired
	DataConfig dataConfig;
	
	
	@Test
	public void test() {
		
		
//		Map<String, String> map = dataConfig.getMap();
//		
//		for(Map.Entry<String, String> entry:map.entrySet()) {
//			
//			System.out.println(entry.getKey()+"-->"+entry.getValue());
//		}
		
		Map<String, DataModel> map = dataConfig.getMap();
		
		for(Map.Entry<String, DataModel> entry:map.entrySet()) {
			
			System.out.println(entry.getKey()+"-->"+entry.getValue());
		}
		

		List<String> list = dataConfig.getList();
		
		
		for (String str : list) {
			System.out.println(str);
		}
	}

}
