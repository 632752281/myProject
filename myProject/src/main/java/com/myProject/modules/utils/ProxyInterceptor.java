package com.myProject.modules.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInterceptor implements InvocationHandler
{
	
	private Object tagObj;
	
	
	public void setTagObj(Object tagObj)
	{
		this.tagObj = tagObj;
	}

	

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable 
	{
		// TODO Auto-generated method stub
		System.out.println("****************start************");
		method.invoke(tagObj, args);
		System.out.println("****************end************");
		return null;
	}

}
