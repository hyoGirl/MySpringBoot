package com.redis.cache.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.redis.cache.mapper.UserMapper;
import com.redis.cache.pojo.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Resource
    private RedisTemplate<String, String> redisTemplate;
	
//	@Autowired
//	private resttem
	
	//如果方法的参数为空，就会报org.springframework.cache.interceptor.SimpleKey cannot be cast to java.lang.String的错误
//	@Cacheable(value="test")
//	@Cacheable(key="'0'")
	public List<User> list(){
	       
		String key = "city_";
		ValueOperations<String, String> operations = redisTemplate.opsForValue();
		
		boolean hasKey = redisTemplate.hasKey(key);
		
//		 if (hasKey) {
//	            Li city = operations.get(key);
//	            return city;
//	        }
		
		 return userMapper.findAllUser();
	 }
	
//	@CacheEvict(value="test",key="'user1_'+#id")
	public boolean delete(int id) {
		return userMapper.deleteUserById(id);
	}
	
	
}
