package com.spring;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestFile {
	
	public static void main(String[] args) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		
		File file=new File("f:\\000.txt");
		
		byte[] buf=new byte[8192];
		
		int len=0;
		
		FileInputStream ins=new FileInputStream(file);
		
		while((len=ins.read(buf))!=-1) {
			
			sb.append(new String(buf, 0, len));
		}
		
		System.out.println(sb.toString());
		
		
		
		
	}

}
