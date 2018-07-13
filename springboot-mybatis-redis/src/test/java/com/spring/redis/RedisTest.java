package com.spring.redis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {
	
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	
	//测试String
	@Test
	public void addString(){
		
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		
		ops.set("key01", "data001");
	}
	
	//放入对象
	@Test
	public void addObject(){
		
		ValueOperations<String, String> ops = redisTemplate.opsForValue();
		
		Pe p1=new Pe("zhangsan",55);
		
		String data = JSON.toJSONString(p1);
		
		ops.set("data_01", data);
		
		String string = ops.get("data_01");
		
		Pe pe = JSONObject.parseObject(string, Pe.class);
		
		System.out.println(pe.toString());
		
	}
	
	
	
	
	@Test
	public void testSort(){
		
		
		ZSetOperations<String, String> ops = redisTemplate.opsForZSet();  
		
		 String key = "foods_map";  
		 Map<String, Integer> map = new HashMap<String, Integer>();
		    map.put("AA",12);
	        map.put("BB",14);
	        map.put("CC",102);
	        map.put("DD",120);
	        map.put("EE",10);
		
	    for (Map.Entry<String, Integer> result:map.entrySet()) {
	    	ops.add(key, result.getKey(), result.getValue());
		}    
       
//        ops.add(key, "test", 4);  
//        ops.add(key, "friute", 0);  
//        ops.add(key, "rice", 1);  
//        ops.add(key, "apple", 1);  
//        ops.add(key, "balane", 5);  
              
        Set<String> sets = ops.rangeByScore(key, 0, 1000);
        
        Long rank = ops.rank(key, "AA");
        
        System.out.println(rank+1);
        
        int i=0;
        for (String value : sets) {  
        	i++;
            System.out.println(value+" -- 第"+i+"名"); 
            
            
        }  
		
	}
	
	
	
	 
	 /**
	  * 说明： 测试对数据进行排序。并且随机取出
	  * @author 徐磊
	  * @time：2018年6月20日 下午5:25:54
	  */
	 @Test
	 public void testAddSortList(){
		 Pe p1=new Pe("AA",12);
		 Pe p2=new Pe("BB",14);
		 Pe p3=new Pe("CC",102);
		 Pe p4=new Pe("DD",120);
		 Pe p5=new Pe("EE",10);
		 
		 List<Pe> list=new ArrayList<Pe>();
		 list.add(p1);
		 list.add(p2);
		 list.add(p3);
		 list.add(p4);
		 list.add(p5);
		 
		 Collections.sort(list);
		 
		 //序列化放入redis中
		
		 ValueOperations<String, String> opsValue = redisTemplate.opsForValue();
		 String data = JSON.toJSONString(list);
		 
		 opsValue.set("list_01", data);
		 
		 List<Pe> parseArray = JSONObject.parseArray(opsValue.get("list_01"), Pe.class);
		 
		 System.out.println(parseArray);
		 
		 //取前面几位
		 System.out.println(parseArray.subList(0, 4));
		 
		 //取其中某一个
		 
	 }
	 
	 @Test
	 public void addMap(){
		 Map<String, Integer> map = new HashMap<String, Integer>();
		 
		    map.put("AA",12);
	        map.put("BB",14);
	        map.put("CC",102);
	        map.put("DD",120);
	        map.put("EE",10);
	        
	     List<Map.Entry<String, Integer>> list = new ArrayList<>(); 
	     
	     list.addAll(map.entrySet()); 
	     
	     Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				
				int flag=o1.getValue()-o2.getValue();
				
				if(flag==0){
					flag=o1.getKey().compareTo(o2.getKey());
				}
				return flag;
			}
		});
	     
	     String jsonString = JSON.toJSONString(list);
	     
	     ValueOperations<String, String> opsValue = redisTemplate.opsForValue();
	     
	     opsValue.set("data_02", jsonString);
	     
	     List<Map> parseArray = JSONObject.parseArray(opsValue.get("data_02"), Map.class);
	     
	     
	     //获取前面几个
	     List<Map> subList = parseArray.subList(0, parseArray.size()-2);
	     
	    // [{value=10, key=EE}, {value=12, key=AA}, {value=14, key=BB}]
	     System.out.println(subList);
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @SuppressWarnings("unchecked")
	 @Test
	 public void addList(){
		 
		 
		 Pe p1=new Pe("AA",12);
		 Pe p2=new Pe("BB",14);
		 Pe p3=new Pe("CC",102);
		 Pe p4=new Pe("DD",120);
		 Pe p5=new Pe("EE",10);
		 
		 List<Pe> list=new ArrayList<Pe>();
		 list.add(p1);
		 list.add(p2);
		 list.add(p3);
		 list.add(p4);
		 list.add(p5);
		 
		 //压入栈中
		 redisTemplate.opsForList().rightPush("pe_test01", list);
		 List<Pe> rightPop = (List<Pe>) redisTemplate.opsForList().rightPop("pe_test01");
		 System.out.println(rightPop);
		 
	 }
	 
}
