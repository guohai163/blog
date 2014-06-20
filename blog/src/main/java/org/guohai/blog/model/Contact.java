package org.guohai.blog.model;

import java.util.Date;

public class Contact {
	
	private int code;
	private String title;
	private String intro;
	private int year;
	private String month;
	private int day;
	private Date date;
	private String term;
	
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

	public int getCode(){
		return code;
	}

	public String getIntro(){
		return intro;
	}
	public int getYear(){
		return year;
	}
	public String getMonth(){
		return month;
	}
	public int getDay(){
		return day;
	}
	public Date getDate(){
		return date;
	}
	public String getTerm(){
		return term;
	}
}
