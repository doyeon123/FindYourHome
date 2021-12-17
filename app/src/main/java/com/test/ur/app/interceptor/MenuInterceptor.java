package com.test.ur.app.interceptor;


import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/**
 * interceptor URLPattern(/,/area/**,/notice/**,/office/**)
 */
public class MenuInterceptor extends HandlerInterceptorAdapter {

	
	private static final Logger logger = LoggerFactory.getLogger(MenuInterceptor.class);
	
	/**
	 * get current user's menu(ex: home,area,notice,office) to set header's Nav active menu
	 * @param request, response
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info(request.getRequestURI());
		StringTokenizer tok =  new StringTokenizer(request.getRequestURI(), "/");
		
		String menu;
		if(!tok.hasMoreElements())
			menu = "home";
		else 
			menu = tok.nextToken();
		
		request.setAttribute("menu",menu);
		
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}
