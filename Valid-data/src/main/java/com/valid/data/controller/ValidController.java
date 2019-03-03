package com.valid.data.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.valid.data.peroson.Person;
import com.valid.data.peroson.PersonList;

@RestController
public class ValidController {

	@PostMapping("/test1")
	public Map<String, Object> test1(@RequestBody @Validated Person person, BindingResult bindingResult) {
		
		System.out.println(person);
		
		System.out.println(person.getBirthday().getTime());

		Map<String, Object> bindingResultMap = new HashMap<>();
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError fieldError : errors) {
				String field = fieldError.getField();
				String defaultMessage = fieldError.getDefaultMessage();
				bindingResultMap.put(field, defaultMessage);
			}
		} else {
			bindingResultMap.put("data", JSON.toJSON(person));
		}
		return bindingResultMap;
	}
	@PostMapping("/test2")
	public Map<String, Object> test2(@RequestBody @Valid List<Person> person, BindingResult bindingResult) {
		
		Map<String, Object> bindingResultMap = new HashMap<>();
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError fieldError : errors) {
				String field = fieldError.getField();
				String defaultMessage = fieldError.getDefaultMessage();
				bindingResultMap.put(field, defaultMessage);
			}
		} else {
			bindingResultMap.put("data", JSON.toJSONString(person));
		}
		return bindingResultMap;
	}
	
	@PostMapping("/test3")
	public Map<String, Object> test3(@RequestBody @Validated PersonList[] person, BindingResult bindingResult) {
		System.out.println("-------");
		
		Map<String, Object> bindingResultMap = new HashMap<>();
		if (bindingResult.hasErrors()) {
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError fieldError : errors) {
				String field = fieldError.getField();
				String defaultMessage = fieldError.getDefaultMessage();
				bindingResultMap.put(field, defaultMessage);
			}
		} else {
			bindingResultMap.put("data", JSON.toJSONString(person));
		}
		return bindingResultMap;
	}

}
