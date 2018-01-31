package com.myProject.modules.template.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myProject.modules.user.bean.User;


@Controller
@RequestMapping(value = "${adminPath}/template")
public class TestTemplate {

	@RequestMapping(value = {"list", ""})
	public String list(@RequestParam(required=false) User User, HttpServletRequest request, HttpServletResponse response, Model model) 
	{
	//	Page<User> page = userService.findPageList(User, new Page<User>()); 
     //   model.addAttribute("page", page);
		
		
		
		model.addAttribute("name", 1);
		return "modules/template/user";
	}
	
}
