package com.mybatis.batch.pojo;

import java.io.Serializable;
import java.text.Collator;
import java.util.Locale;

public class Person implements Serializable,Comparable<Person>{
	
	private static final long serialVersionUID = 4874926761139096420L;

	private int id;
	
	private String name;
	
	private int age;
	
	private int sex;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

	/**
	 * 针对中文排序，要注释
	 */
	@Override
	public int compareTo(Person o) {
		
		Collator instance = Collator.getInstance(Locale.CHINA);
		int compare = instance.compare(this.name, o.name);
		return compare;
		
		//0代表相等，1表示大于，-1表示小于
//		int temp=(this.name).compareTo(o.name);
//		System.out.println(this.name+"   "+temp);
//		return temp==0 ?this.age-o.age:temp;
	}
	
	
}
