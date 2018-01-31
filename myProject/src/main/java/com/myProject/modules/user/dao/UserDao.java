package com.myProject.modules.user.dao;

import java.util.List;
import java.util.Set;

import com.myProject.common.annotation.MyBatisDao;
import com.myProject.common.bean.Page;
import com.myProject.modules.user.bean.User;

@MyBatisDao
public interface UserDao 
{

	User findUserByName(String name);
	
	Set<String> findRolesByName(String name);
	
	List<User> findList (User User);
	
	List<User> findPageList (Page<User> page);
	
	User findOne (User user);
	
	int addUser (User user);
	
	int updateUser (User user);
	
	int delUser (User user);
	
	int addAllUser (List<User> users);
	
	int updateAllUser (List<User> users);
	
	int delAllUser (List<User> users);
	
}
