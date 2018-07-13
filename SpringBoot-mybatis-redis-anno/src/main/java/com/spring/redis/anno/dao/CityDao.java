package com.spring.redis.anno.dao;

import java.util.List;

import com.spring.redis.anno.pojo.City;

public interface CityDao {

	 City searchCityById(Long id);

	 List<City> getAllCity();

	 void saveCity(City city);

	 void deleteCity(Long id);

	void modifyCity(City city); 
}
