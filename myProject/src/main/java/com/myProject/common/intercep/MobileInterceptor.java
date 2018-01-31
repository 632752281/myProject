package com.myProject.common.intercep;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class MobileInterceptor  implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
			Object handler) throws Exception {
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			ModelAndView modelAndView) throws Exception {
		if (modelAndView != null){
			// ������ֻ���ƽ����ʵĻ�������ת���ֻ���ͼҳ�档
			if(null != modelAndView.getViewName() && modelAndView.getViewName().equals("redirect:"))
			{
				modelAndView.setViewName("mobile/" + modelAndView.getViewName());
			}
		}
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception ex) throws Exception {
	}
	
}	