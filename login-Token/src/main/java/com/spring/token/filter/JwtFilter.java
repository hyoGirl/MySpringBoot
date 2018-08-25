package com.spring.token.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.token.util.JwtUtil;
import com.spring.token.util.SimpleJwtUtil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtFilter implements Filter{
	
	

	private static final ServletRequest HttpServletRequest = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req=(HttpServletRequest)request;
		
		HttpServletResponse resp=(HttpServletResponse)response;
//		String header = req.getHeader("Authorization");
//		req.getParameter("token");
		
		String authHeader = req.getHeader("Authorization");
		String requestURI = req.getRequestURI();
		if(req.getRequestURI().endsWith("login") || RequestMethod.OPTIONS.toString().equals(req.getMethod()) || req.getRequestURI().endsWith(".ico") ) {
			chain.doFilter(request, response);
		}else {
			if(authHeader == null || authHeader.trim() == "") {
				throw new SignatureException("not found Token.");
			}
	//		Claims claims = JwtUtil.parseJWT(authHeader);
			Map<String,Object> responseMap=new HashMap<String,Object> ();
			
			try {
				if(JwtUtil.validateJWT(authHeader)) {
					Claims c = JwtUtil.parseJWT(authHeader);
					System.out.println(c.getId());//jwt
			        System.out.println(c.getIssuedAt());//Mon Feb 05 20:50:49 CST 2018
			        System.out.println("用户名："+c.getSubject());//{id:100,name:xiaohong}
			        System.out.println("签发者："+c.getIssuer().toString());//null
			        System.out.println(c.get("uid", String.class));//DSSFAWDWADAS...
			        System.out.println(c.getExpiration());
					chain.doFilter(request, response);
				}
			} catch (SignatureException | ExpiredJwtException e) {
	//			e.printStackTrace();
				PrintWriter writer = resp.getWriter();
			    writer.write("need refresh token");
	            writer.close();
			}
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
