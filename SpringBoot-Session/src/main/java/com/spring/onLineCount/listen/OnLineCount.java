package com.spring.onLineCount.listen;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class OnLineCount implements HttpSessionListener{
	
	
	private  int count=0;

	@Override
	public synchronized void sessionCreated(HttpSessionEvent se) {
		
		System.out.println("【HttpSessionListener监听器】count++  增加");
		
		count++;
		se.getSession().getServletContext().setAttribute("count", count);
		
	}

	@Override
	public synchronized void sessionDestroyed(HttpSessionEvent se) {
		
		 System.out.println("【HttpSessionListener监听器】count--  减少");
		 
		 count--;
		 
		 se.getSession().getServletContext().setAttribute("count", count);
	}

}
