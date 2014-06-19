package org.guohai.blog.model;

public class Contact {
	
	private int code;
	private String title;
	private String intro;
	
	public Contact(int code,String title,String intro){
		super();
		this.code=code;
		this.title=title;
		this.intro=intro;
	}

	public Contact(){}
	
	public String getTitle(){
		return title;
	}
	

	public String getIntro(){
		return intro;
	}
}
