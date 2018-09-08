package com.mybatis.batch.service;

import java.util.List;

import com.mybatis.batch.pojo.Person;

public interface PersonService {

	
	void addPerson(Person person);
	
	void batchAddPerson(List<Person> persons);
	
	void batchDeletePerson(int[] ids);
	
	void batchUpdatePerson(List<Person> persons);
	
	List<Person> batchFindPerson(int[] ids);
}
