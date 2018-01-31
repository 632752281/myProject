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
       logger.info("======用户登陆数据认证======");
/*        String userName = arg0.getPrincipal().toString();
        User user = userService.findUserByName(userName);
        if (user!=null) {
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getName(), user.getPass(), getName());
            return authenticationInfo;
        }
        return null;*/
       //PrincipalCollection principal = (PrincipalCollection)authcToken.getPrincipal();
		// 校验用户名密码
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
		
        logger.info("======用户授权登录认证======");
/*        String userName = principals.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(userService.findRolesByName(userName));
        return simpleAuthorizationInfo;*/

		// 获取当前已登录的用户
		// 如果是登录进来的，则踢出已在线用户
		if (SecurityUtils.getSubject().isAuthenticated()){
			 
		}
		else{
			// 记住我进来的，并且当前用户已登录，则退出当前用户提示信息。
			SecurityUtils.getSubject().logout();
			throw new AuthenticationException("msg:账号已在其它地方登录，请重新登录。");
		}
		User user = userService.findUserByName(principals.getPrimaryPrincipal().toString());
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			// 添加用户权限
			info.addStringPermission("user");
			// 添加用户角色信息
			info.setRoles(userService.findRolesByName(principals.getPrimaryPrincipal().toString()));
			return info;
		} else {
			return null;
		}
		
	}
	
	
	
}
