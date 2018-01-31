package com.myProject.modules.user.service;

import java.util.List;
import java.util.Set;

import com.myProject.common.bean.Page;
import com.myProject.modules.user.bean.User;

public interface UserService 
{

	/** ��ҳ��ѯ
	 * @param User
	 * @param page
	 * @return
	 */
	Page<User> findPageList(User User,Page<User> page);
	
	/** ��ѯ����
	 * @param User
	 * @return
	 */
	List<User> findList(User User);
	
	/**��ѯ ����
	 * @param user
	 * @return
	 */
	User findOne(User user);
	
	
	/**��ѯ ���� ���ݵ�¼����
	 * @param user
	 * @return
	 */
	User findUserByName(String name);
	
	
	
	/**��ѯ �û����ƶ��ڵ� ��ɫ���� ���
	 * @param user
	 * @return
	 */
	Set<String> findRolesByName(String name);
	
	
	
	/**��ѯ ����
	 * @param user
	 * @return
	 */
	User testUser(User user);
	
	
    /**���
     * @param user
     * @return
     */
    boolean addUser(User user);
	
    /**����
     * @param user
     * @return
     */
    boolean updateUser(User user);
	
    /**ɾ��
     * @param user
     * @return
     */
    boolean delUser(User user);
	
    /**�������
     * @param user
     * @return
     */
	boolean addAllUser(List<User> users);
	
    /**��������
     * @param user
     * @return
     */
	boolean updateAllUser(List<User> users);
	
    /**����ɾ��
     * @param user
     * @return
     */
	boolean delAllUser(List<User> users);
}
