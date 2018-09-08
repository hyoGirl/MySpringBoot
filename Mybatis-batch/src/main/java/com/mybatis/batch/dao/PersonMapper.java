package com.mybatis.batch.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mybatis.batch.pojo.Person;
@Mapper
public interface PersonMapper {

	
	void  addPerson(Person person);
	
	void batchAddPerson(@Param("persons")List<Person> persons);

	void batchDeletePerson(@Param("ids")int[] ids);

	void batchUpdatePerson(@Param("persons")List<Person> persons);

	List<Person> batchFindPerson(@Param("ids")int[] ids);
}
