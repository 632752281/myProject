package com.myProject.modules.utils;

import com.myProject.modules.user.bean.User;

public class TestServiceImpl implements TestService
{

	public User testUser(User user) 
	{
		System.out.println("test");
		return user;
	}
}
