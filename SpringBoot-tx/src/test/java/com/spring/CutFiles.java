package com.spring;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CutFiles {
	public static void main(String[] args) throws IOException {
		
		String ss="f:\\001.mp3";
		//定义输入流，读取文件数据
		FileInputStream fis = new FileInputStream(ss);
		
		//定义数组，保存读取的字节数据
		byte[] buf = new byte[51200];
		//定义变量，充当碎片文件的文件名
		int cnt = 1;
		//定义变量，记录读取的字节个数
		int len = 0;
		//使用循环读取数据
		while( ( len = fis.read(buf) ) != -1 ){
			//创建输出流对象，将读取的50kb字节数据写到一个碎片文件中
			String s1="f:\\001";
			FileOutputStream fos = new FileOutputStream(s1+cnt+".mp3");
			//将读取的数据写到碎片中
			fos.write(buf, 0, len);
			cnt++;
			//关闭流对象
			fos.close();
		}
		//关闭输入流对象
		fis.close();
	}
}
