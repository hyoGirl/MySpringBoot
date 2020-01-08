package com.mybatis.plus.service;

import com.alibaba.fastjson.JSON;
import com.mybatis.plus.entity.Plus;

public class Test {
	
	public static void main(String[] args) {
		
//		Plus plus=new Plus();
//
//		plus.setAddress("AAA");
//		plus.setAge(12);
//		plus.setName("name01");
//		plus.setPwd("pwd01");
//
//
//
//		System.out.println(JSON.toJSON(plus));

		A a=new A();
		change(a);
		System.out.println(a.age);

		System.out.println("================");

		int[] arr={1,2,3,4};
		doarr(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}


	private static void doarr(int[] arr) {
		arr=null;
	}


	private static void change(A a) {
		a.age=20;
	}

}

class  A{

	int age=10;
}