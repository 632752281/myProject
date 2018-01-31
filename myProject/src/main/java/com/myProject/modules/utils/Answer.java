package com.myProject.modules.utils;

import java.util.ArrayList;
import java.util.List;

public class Answer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getDict("abc efd 123 asd  123").size());
		
		
		System.out.println(getNum(100, 0));
	}

	
	
	
	public static List<String> getDict(String str)
	{
		List<String> result = new ArrayList<String>();
		if(null == str || "".equals(str))
		{
			return result;
		}
		for(String temp:str.split(" "))
		{
			if(null != temp && !"".equals(temp))
			{
				result.add(temp);
			}
		}
		return result;
	}
	
	
	
	
	public static long getCount(int num)
	{
		if(num < 1)
		{
			return 1L;
		}
		return num*getCount(num-1);
	}
	
	public static long getNum(int num,long result)
	{
		if(num < 1)
		{
			return result;
		}
		return getNum(num-1, getCount(num)+result);
	}
	
	
	
	
}
