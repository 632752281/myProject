package com.myProject.common.shiro;

import java.util.Collection;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myProject.modules.user.bean.User;
import com.myProject.modules.user.service.UserService;

public class ShiroDbRealm extends AuthorizingRealm
{

    private static final Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);
    @Autowired
    private UserService userService;
    
    


	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException 
	{
       logger.info("======�û���½������֤======");
/*        String userName = arg0.getPrincipal().toString();
        User user = userService.findUserByName(userName);
        if (user!=null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getName(), user.getPass(), getName());
            return authenticationInfo;
        }
        return null;*/
       //PrincipalCollection principal = (PrincipalCollection)authcToken.getPrincipal();
		// У���û�������
		User user = userService.findUserByName(authcToken.getPrincipal().toString());
		if (user != null) {
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getName(), user.getPass(), getName());
            return authenticationInfo;
		} else {
			return null;
		}
		
	}

	
	
	
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		
        logger.info("======�û���Ȩ��¼��֤======");
/*        String userName = principals.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(userService.findRolesByName(userName));
        return simpleAuthorizationInfo;*/

		// ��ȡ��ǰ�ѵ�¼���û�
		// ����ǵ�¼�����ģ����߳��������û�
		if (SecurityUtils.getSubject().isAuthenticated()){
			 
		}
		else{
			// ��ס�ҽ����ģ����ҵ�ǰ�û��ѵ�¼�����˳���ǰ�û���ʾ��Ϣ��
			SecurityUtils.getSubject().logout();
			throw new AuthenticationException("msg:�˺����������ط���¼�������µ�¼��");
		}
		User user = userService.findUserByName(principals.getPrimaryPrincipal().toString());
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			// ����û�Ȩ��
			info.addStringPermission("user");
			// ����û���ɫ��Ϣ
			info.setRoles(userService.findRolesByName(principals.getPrimaryPrincipal().toString()));
			return info;
		} else {
			return null;
		}
		
	}
	
	
	
}
