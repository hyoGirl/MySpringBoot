package com.spring.redis.anno.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.spring.redis.anno.dao.CityDao;
import com.spring.redis.anno.pojo.City;

@CacheConfig(cacheNames = "cityCache")
@Service
public class CityService {
	
	public static final String CACHE_TEST = "_cache_test";// 缓存key
	
	public static final String CACHE_ALL = "_cache_all";// 缓存key
	
	@Autowired
	private CityDao cityDao;
	
	//p0代表了第一个参数  key = "'" + CacheKey.ROLES_NAME + "'+#roleIds"
	@Cacheable(key ="'"+CACHE_TEST+"'+#p0")  
	public City findCityById(Long id) {
		return cityDao.searchCityById(id);
	}
	//value 就是cacheNames的别名。两者一样的意思
//	@Cacheable(cacheNames="CityInfo",key="'"+CACHE_TEST+"'")
	
	
	//换另外一个缓存
	@Cacheable(cacheNames="all_city", key="'"+CACHE_ALL+"'")
	public List<City> findAll() {
		return cityDao.getAllCity();
	}

	
//	@CachePut(value = "CityInfo",key="'"+CACHE_TEST+"'")
	//换一个缓存来保存数据。并指定Key
	@CachePut(key = "'"+CACHE_TEST+"'+#p0.id")  
	public City updateCity(City city) {
		
		cityDao.modifyCity(city);
		return cityDao.searchCityById(city.getId());
	}
	
	@CachePut(key = "'"+CACHE_TEST+"'+#p0.id")  
	public City addCity(City city) {
		
		cityDao.saveCity(city);
		return cityDao.searchCityById(city.getId());
		
	}
	/**
     * 对符合key条件的记录从缓存中book1移除
     */
	@CacheEvict(key = "'"+CACHE_TEST+"'+#p0") 
	public void deleteCityById(Long id) {
		cityDao.deleteCity(id);
	}
	

}
