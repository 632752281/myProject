package com.myProject.modules.user.service;

import java.util.List;
import java.util.Set;

import com.myProject.common.bean.Page;
import com.myProject.modules.user.bean.User;

public interface UserService 
{

	/** 分页查询
	 * @param User
	 * @param page
	 * @return
	 */
	Page<User> findPageList(User User,Page<User> page);
	
	/** 查询集合
	 * @param User
	 * @return
	 */
	List<User> findList(User User);
	
	/**查询 单个
	 * @param user
	 * @return
	 */
	User findOne(User user);
	
	
	/**查询 单个 根据登录名称
	 * @param user
	 * @return
	 */
	User findUserByName(String name);
	
	
	
	/**查询 用户名称对于的 角色名称 结合
	 * @param user
	 * @return
	 */
	Set<String> findRolesByName(String name);
	
	
	
	/**查询 单个
	 * @param user
	 * @return
	 */
	User testUser(User user);
	
	
    /**添加
     * @param user
     * @return
     */
    boolean addUser(User user);
	
    /**更新
     * @param user
     * @return
     */
    boolean updateUser(User user);
	
    /**删除
     * @param user
     * @return
     */
    boolean delUser(User user);
	
    /**批量添加
     * @param user
     * @return
     */
	boolean addAllUser(List<User> users);
	
    /**批量更新
     * @param user
     * @return
     */
	boolean updateAllUser(List<User> users);
	
    /**批量删除
     * @param user
     * @return
     */
	boolean delAllUser(List<User> users);
}
