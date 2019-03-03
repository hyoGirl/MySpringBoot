package com.mybatis.batch.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.batch.BatchApp;
import com.mybatis.batch.pojo.Person;
import com.mybatis.batch.service.PersonService;

@SpringBootTest(classes = BatchApp.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceImplTest {

	@Autowired
	PersonService personService;

	@Test
	public void testBatchAddPerson() {

		Person person = new Person();

		person.setAge(12);
		person.setName("张4");
		person.setSex(1);

		Person person2 = new Person();

		person2.setAge(12);
		person2.setName("李5");
		person2.setSex(1);

		List<Person> persons = new ArrayList<Person>();
		persons.add(person2);
		persons.add(person);

		personService.batchAddPerson(persons);

	}

	@Test
	public void addPerson() {

		Person person = new Person();

		person.setAge(12);
		person.setName("王wu");
		person.setSex(1);
		personService.addPerson(person);
	}

	@Test
	public void testBatchDeletePerson() {
		int[] ids = { 1, 2 };
		personService.batchDeletePerson(ids);

	}

	@Test
	public void testBatchUpdatePerson() {
		
		int[] ids = { 5,6 };
		List<Person> persons = personService.batchFindPerson(ids);
		
		for (Person person : persons) {
			person.setAge(22);
		}
		
		personService.batchUpdatePerson(persons);

	}

	@Test
	public void testBatchFindPerson() {
		int[] ids = { 1, 2 ,3,4,5,6,7,8};
		List<Person> list = personService.batchFindPerson(ids);
		//调用排序，
		Collections.sort(list);
		for (Person person : list) {
			System.out.println(person);
		}
	}

}
