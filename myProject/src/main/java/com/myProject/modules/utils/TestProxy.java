package com.myProject.modules.utils;


import net.sf.cglib.proxy.Enhancer;

import org.junit.Test;

import com.myProject.modules.user.bean.User;
import com.myProject.modules.user.service.UserService;
import com.myProject.modules.user.service.impl.UserServiceImpl;

public class TestProxy {

	
/*	@Test
	public void test1 ()
	{
		ProxyInterceptor proxyInterceptor = new ProxyInterceptor();
		
		UserService userService = new UserServiceImpl();
		proxyInterceptor.setTagObj(userService);
		
		UserService userServiceProxy = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), proxyInterceptor);
		
		//---------代理-------
		userServiceProxy.testUser(new User("1"));
		
		//----------new-------
		userService.testUser(new User("1"));
	}*/
	
	
	@Test
	public void test2 ()
	{
		
		Enhancer enhancer  = new Enhancer();
		enhancer.setSuperclass(UserServiceImpl.class);
		enhancer.setCallback(new TestProxyCallBack());
		
		UserService  userServiceProxy = (UserService) enhancer.create();
		UserService userService2 = new UserServiceImpl();
		//---------代理-------
		userServiceProxy.testUser(new User("1"));
		//----------new-------
		userService2.testUser(new User("1"));
		
	}
	
	
	
	
	
	
	
	
	
}
