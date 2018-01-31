package com.myProject.modules.utils;

public class Worker {

	private String id;
	private String name;
	private String no;
	
	public Worker(){}
	
	public Worker(String id,String name,String no)
	{
		this.id = id ;
		this.name = name ;
		this.no = no ;
	}
	
	
	@Override
	public String toString() {
		return "Worker [id=" + id + ", name=" + name + ", no=" + no + "]";
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	

	
	
}
