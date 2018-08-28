package com.spring;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

	
	public static void main(String[] args) {
		
		
		String ss="/login";
		
		String s1="/aa/login";
		
		System.out.println(s1.endsWith(ss));
		
		
		List<Person> list=new ArrayList<Person>();
		
		list.add(new Person(1, "CC"));
		list.add(new Person(2, "Ab"));
		
//		Collections.sort(list);
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				
				
				return o1.getName().compareTo(o2.getName());
			}
			
			
		});
		for (Person person : list) {
			System.out.println(person);
		}
		
	}
}
