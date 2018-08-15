package com.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTx {

	public static void main(String[] args) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = new Date();
		String t = df.format(d);
		long epoch = 0;
		try {
			epoch = df.parse(t).getTime() / 1000;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("时间戳是：" + epoch);

	}

}
