package com.myProject.common.intercep;


import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class LogInterceptor implements HandlerInterceptor {

	private static final ThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("ThreadLocal StartTime");
	
	/**
	 * ��־����
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {
		if (logger.isDebugEnabled()){
			long beginTime = System.currentTimeMillis();//1����ʼʱ��  
	        startTimeThreadLocal.set(beginTime);		//�̰߳󶨱�����������ֻ�е�ǰ������߳̿ɼ���  
	        logger.debug("��ʼ��ʱ: {}  URI: {}", new SimpleDateFormat("hh:mm:ss.SSS")
	        	.format(beginTime), request.getRequestURI());
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, 
			ModelAndView modelAndView) throws Exception {
		if (modelAndView != null){
			logger.info("ViewName: " + modelAndView.getViewName());
		}
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object handler, Exception ex) throws Exception {

		// ��ӡJVM��Ϣ��
		if (logger.isDebugEnabled()){
			long beginTime = startTimeThreadLocal.get();//�õ��̰߳󶨵ľֲ���������ʼʱ�䣩  
			long endTime = System.currentTimeMillis(); 	//2������ʱ��  
	        logger.debug("��ʱ������{}  ��ʱ��{}  URI: {}  ����ڴ�: {}m  �ѷ����ڴ�: {}m  �ѷ����ڴ��е�ʣ��ռ�: {}m  �������ڴ�: {}m",
	        		new SimpleDateFormat("hh:mm:ss.SSS").format(endTime), (endTime - beginTime),
					request.getRequestURI(), Runtime.getRuntime().maxMemory()/1024/1024, Runtime.getRuntime().totalMemory()/1024/1024, Runtime.getRuntime().freeMemory()/1024/1024, 
					(Runtime.getRuntime().maxMemory()-Runtime.getRuntime().totalMemory()+Runtime.getRuntime().freeMemory())/1024/1024); 
		}
		
	}
}
