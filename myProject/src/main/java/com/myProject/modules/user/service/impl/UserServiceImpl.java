package com.myProject.modules.user.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProject.common.bean.Page;
import com.myProject.modules.user.bean.User;
import com.myProject.modules.user.dao.UserDao;
import com.myProject.modules.user.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao userDao; 
	
	
	public Page<User> findPageList(User User,Page<User> page) 
	{
         page.setObject(User);
         page.setResults( userDao.findPageList(page));
		return page;
	}

	public List<User> findList(User User) 
	{
		return userDao.findList(User);
	}
	
	public User testUser(User user)
	{
		System.out.println("test");
		return user;
	}
	
	
	public User findUserByName(String name) 
	{
		return userDao.findUserByName(name);
	}
	
	
	public Set<String> findRolesByName(String name) 
	{
		return userDao.findRolesByName(name);
	}
	
	
	public User findOne(User user) 
	{
		return userDao.findOne(user);
	}

	public boolean addUser(User user) 
	{
		if(userDao.addUser(user) > 0)
		{
			return true;
		}
		return false;
	}

	public boolean updateUser(User user) 
	{
		if(userDao.updateUser(user) > 0)
		{
			return true;
		}
		return false;
	}

	public boolean delUser(User user)
	{
		if(userDao.delUser(user) > 0)
		{
			return true;
		}
		return false;
	}

	public boolean addAllUser(List<User> users) 
	{
		if(userDao.addAllUser(users) > 0)
		{
			return true;
		}
		return false;
	}

	public boolean updateAllUser(List<User> users) 
	{
		if(userDao.updateAllUser(users) > 0)
		{
			return true;
		}
		return false;
	}

	public boolean delAllUser(List<User> users) 
	{
		if(userDao.delAllUser(users) > 0)
		{
			return true;
		}
		return false;
	}



}
