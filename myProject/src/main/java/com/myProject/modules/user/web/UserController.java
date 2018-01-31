package com.myProject.modules.user.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myProject.common.bean.Page;
import com.myProject.modules.user.bean.User;
import com.myProject.modules.user.service.UserService;

@Controller
@RequestMapping(value = "${adminPath}/user")
public class UserController 
{

	/**
	 * user service 
	 */
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User get(@RequestParam(required=false) String id) 
	{
		if (null != id && !"".equals(id))
		{
			return userService.findOne(new User(id));
		}else{
			return new User();
		}
	}
	
	
	
	@RequestMapping(value = {"list", ""})
	public String list(@RequestParam(required=false) User User, HttpServletRequest request, HttpServletResponse response, Model model) 
	{
	//	Page<User> page = userService.findPageList(User, new Page<User>()); 
     //   model.addAttribute("page", page);
		return "modules/user/userPageList";
	}
	
	
	@RequestMapping(value = "userList")
	public String userList(@RequestParam(required=false) User User, HttpServletRequest request, HttpServletResponse response, Model model) 
	{
		List<User> list = userService.findList(User); 
        model.addAttribute("list", list);
		return "modules/user/userList";
	}
	
	@ResponseBody
	@RequestMapping(value = "getUserList",method ={RequestMethod.POST,RequestMethod.GET})
	public List<Map<String, Object>> getUserList(@RequestParam(required=false) User User, HttpServletRequest request, HttpServletResponse response, Model model) 
	{
		List<User> list = userService.findList(User); 
    //    model.addAttribute("list", list);
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		for (int i=0; i<list.size(); i++)
		{
			User e = list.get(i);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", e.getId());
			//HTML ±àÂë ·´×ªÒå
			map.put("name",e.getName());
			mapList.add(map);
		}
		return mapList;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "getUserPageList")
	public Map<String, Object> getUserPageList(
			@RequestParam(value="page", required=false) String page,
			@RequestParam(value="rows", required=false) String rows,
			@RequestParam(value="id", required=false) String id,
			@RequestParam(value="name", required=false) String name,
			HttpServletRequest request, HttpServletResponse response, Model model) 
	{
		Map<String, Object> map = new HashMap<String, Object>();
		Page<User> pageList = userService.findPageList(new User(id,name), new Page<User>(page,rows)); 
		List<User> list = pageList.getResults();
		map.put("total",pageList.getTotalRecord());
		map.put("rows", list);
		return map;
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "getUserPageList1")
	public String getUserPageList1(@RequestParam(required=false) User User, HttpServletRequest request, HttpServletResponse response, Model model) 
	{
		return "{\"total\":2,\"rows\":[{\"id\":\"1\",\"name\":\"1\"},{\"id\":\"2\",\"name\":\"2\"}]}";
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "form")
	public String form(@RequestParam(required=false) String id, HttpServletRequest request, HttpServletResponse response, Model model) 
	{
        model.addAttribute("user",userService.findOne(new User(id)));
		return "modules/user/userForm";
	}
	
	
}
