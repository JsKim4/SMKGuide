package org.kjs.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.DelegatingFilterProxy;

public class CustomDelegatingFilterProxy extends DelegatingFilterProxy {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
		if(uri.contains("mobile")||uri.contains("info")) {
			filterChain.doFilter(request, response);
		}
		else
			super.doFilter(request, response, filterChain);
	}
	
}
