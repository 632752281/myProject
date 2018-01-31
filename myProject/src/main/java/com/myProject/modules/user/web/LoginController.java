package com.myProject.modules.user.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myProject.modules.user.bean.User;
import com.myProject.modules.user.service.UserService;


@Controller
public class LoginController 
{
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    
	@Autowired
    private UserService userService;
	 
	 
    @RequestMapping("${adminPath}/login")
    public String login(User user,Model model)
    {
    	if(null == user.getName()|| null == user.getPass())
    	{
    		 logger.error("======�������˻�����=======");
             model.addAttribute("msg", "�������˻�����");
            // e.printStackTrace();
             return "modules/login/fail";
    	}
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(),user.getPass());
        try {
            subject.login(usernamePasswordToken);
            logger.info("======��½�ɹ�=======");
            return "modules/login/index";
        } catch (Exception e) {
            logger.error("======��½�쳣=======");
            model.addAttribute("msg", "�û��������������,��½ʧ��");
           // e.printStackTrace();
            return "modules/login/fail";
        }
    }
    
    
    
    @RequestMapping("${adminPath}/error")
    public String error(Model model)
    {
    	 return "modules/login/error";
    }
    
    
    @RequestMapping("${adminPath}/fail")
    public String fail(Model model)
    {
    	 return "modules/login/fail";
    }
    
}
