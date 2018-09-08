package com.mybatis.batch.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybatis.batch.dao.PersonMapper;
import com.mybatis.batch.pojo.Person;
import com.mybatis.batch.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonMapper personMapper;
	
	

	@Override
	public void batchAddPerson(List<Person> persons) {
		// TODO Auto-generated method stub
		personMapper.batchAddPerson(persons);
	}

	@Override
	public void batchDeletePerson(int[] ids) {
		// TODO Auto-generated method stub
		personMapper.batchDeletePerson(ids);
	}

	@Override
	public void batchUpdatePerson(List<Person> persons) {
		// TODO Auto-generated method stub
		personMapper.batchUpdatePerson(persons);
	}

	@Override
	public List<Person> batchFindPerson(int[] ids) {
		// TODO Auto-generated method stub
		return personMapper.batchFindPerson(ids);
	}

	@Override
	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		personMapper.addPerson(person);
	}

}
