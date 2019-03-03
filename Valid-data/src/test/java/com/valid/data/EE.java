package com.valid.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EE {
	
	public static void main(String[] args) throws ParseException {
		
		
		
		Date t1=new Date();
		
		
		System.out.println(t1.getTime());
		
		long time = t1.getTime();
		
		
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date date = new Date(time);
		
		
		System.out.println(simpleDateFormat.format(date));
		
		String ss="2018-09-13 00:46:40.810";
		
		Date parse = simpleDateFormat.parse(ss);
		System.out.println(parse);
		String format = simpleDateFormat.format(parse);
		System.out.println(format);
		
		String s1="2001-07-04 12:08:56.235";
//		994219736235
//		994248536235
		Date parse1 = simpleDateFormat.parse(s1);
		System.out.println(parse1.getTime());
		
		Date ty=new Date();
		ty.setTime(994219736235L);
		String format2 = simpleDateFormat.format(ty);
		System.out.println(format2);
		
		
		
	}
	
	
	
}
