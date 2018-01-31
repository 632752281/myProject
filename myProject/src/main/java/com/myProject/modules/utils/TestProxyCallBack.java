package com.myProject.modules.utils;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class TestProxyCallBack implements MethodInterceptor
{

	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable 
	{
		// TODO Auto-generated method stub
		 System.out.println("start Transaction by cglib");
		arg3.invokeSuper(arg0, arg2);
		 System.out.println("end Transaction by cglib");
		return null;
	}

}
