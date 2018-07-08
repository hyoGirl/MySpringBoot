package com.spring.redis.anno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.redis.anno.pojo.City;
import com.spring.redis.anno.service.CityService;

@RestController
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/api/city")
	public List<City> findAllCity(){
		
		return cityService.findAll();
	}
	
	
	@GetMapping("/api/city/{id}")
	public City findOneCity(@PathVariable("id") Long id){
		return cityService.findCityById(id);
	}
	
	
	@RequestMapping(value="/api/city",method=RequestMethod.POST)
	public void insertCity(@RequestBody City city){
		cityService.addCity(city);
	}
	
	@RequestMapping(value = "/api/city/{id}", method = RequestMethod.DELETE)
	public void deleteCity(@PathVariable("id") Long id){
		
		cityService.deleteCityById(id);
	}
	
	@RequestMapping(value="/api/city",method=RequestMethod.PUT)
	public void updateCity(@RequestBody City city){
		
		cityService.updateCity(city);
	}
	
	
	
	
}
