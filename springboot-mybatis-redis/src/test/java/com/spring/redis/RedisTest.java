package com.spring.redis;

import java.util.ArrayList;
import java.util.Arrays;
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

	@Test
	public void test10W(){

//		for (int i = 0; i < 10000*10; i++) {
//			redisTemplate.opsForList().leftPush("wx10","ASDFG"+i);
//		}
//
//
		Long wx10 = redisTemplate.opsForList().size("wx10");

		int len = wx10.intValue();
		int temp=0;
		int temp2=0;

		int count=len%9000==0?len/9000:len/9000+1;


		System.out.println("遍历次数为："+count);
		for (int i = 0; i < count; i++) {
			temp=i*9000;
			temp2=temp+9000;
			if(i!=0){
				temp=i*9000+1;
			}

			if(temp2>=len){
				temp2=len;
			}
			List list101 = redisTemplate.opsForList().range("wx10", temp, temp2);
			System.out.println(list101.size());
			System.out.println(temp+"----"+temp2+"--------------?"+list101.size());
		}

//
//
//
//		List wx101 = redisTemplate.opsForList().range("wx10", 0, 1);
//		System.out.println(wx10);
//		System.out.println(wx101);

	}

	@Test
	public void test878922(){
//		for (int i = 0; i < 878922; i++) {
////			// 模拟栈插入
//			redisTemplate.opsForList().leftPush("list878922","ASDFG"+i);
//		}

		Long wx10 = redisTemplate.opsForList().size("list878922");

		int num=5000;
		int len = wx10.intValue();
		int temp=0;
		int temp2=0;

		int count=len%num==0?len/num:len/num+1;
		System.out.println("遍历次数为："+count);
		for (int i = 0; i < count; i++) {
			temp=i*num;
			temp2=temp+num;
			if(i!=0){
				temp=i*num+1;
			}

//			if(temp2>=len){
//				temp2=len;
//			}
			List list101 = redisTemplate.opsForList().range("list878922", temp, temp2);
			if(list101.size()==0){
				return;
			}
//			System.out.println(list101.size());
//			System.out.println(list101);
			System.out.println(temp+"----"+temp2+"--------------?"+list101.size());
		}

	}


	@Test
	public void test10(){
//		for (int i = 0; i < 10; i++) {
////			// 模拟栈插入
////			redisTemplate.opsForList().leftPush("list10","ASDFG"+i);
////		}

		Long wx10 = redisTemplate.opsForList().size("list10");

		int num=8;
		int len = wx10.intValue();
		int temp=0;
		int temp2=0;

		int count=len%num==0?len/num:len/num+1;
		System.out.println("遍历次数为："+count);
		for (int i = 0; i < count; i++) {
			temp=i*num;
			temp2=temp+num;
			if(i!=0){
				temp=i*num+1;
			}

//			if(temp2>=len){
//				temp2=len;
//			}
			List list101 = redisTemplate.opsForList().range("list10", temp, temp2);
			if(list101.size()==0){
				return;
			}
//			System.out.println(list101.size());
			System.out.println(list101);
			System.out.println(temp+"----"+temp2+"--------------?"+list101.size());
		}

	}

	@Test
	public void testGet102(){
		Long size10 = redisTemplate.opsForList().size("list10");
		int list10=size10.intValue();
		int temp=0;
		int temp2=0;

		int count=list10/2+1;
		for (int i = 0; i < count; i++) {
			temp=i*2;
			temp2=temp+2;
			if(i!=0){
				temp=i*2+1;
			}

			if(temp2>=list10){
				temp2=list10;
			}
			List list101 = redisTemplate.opsForList().range("list10", temp, temp2);
			System.out.println(list101);
			System.out.println(temp+"----"+temp2+"--------------?"+list101.size());
			if(temp2>=list10){
				return ;
			}
		}

	}


	@Test
	public void testGet10(){
		Long size10 = redisTemplate.opsForList().size("list10");
		int list10=size10.intValue();
		int temp=0;
		int temp2=0;

		int count=list10/2+1;
		for (int i = 0; i < count; i++) {
			temp=i*2;
			temp2=temp+2;
			if(i!=0){
				temp=i*2+1;
			}

			if(temp2>=list10){
				temp2=list10;
			}
			System.out.println(temp+"----"+temp2);
			List list101 = redisTemplate.opsForList().range("list10", temp, temp2);
			System.out.println(list101);
			if(temp2>=list10){
				return ;
			}
		}
	}

	
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
