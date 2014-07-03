package org.guohai.blog.model;

import java.util.Date;

public class Contact {
	
	private int code;
	private String title;
	private String intro;
	private int year;
	private String month;
	private int iMonth;
	private String sDate;
	private int day;
	private Date date;
	private String term;
	private String smallTitle;
	
	public Contact(int code,String title,String intro){
		super();
		this.code=code;
		this.title=title;
		this.intro=intro;
	}

	public Contact(){}
	
	public int getIMonth(){
		return iMonth;
	}
	
	public String getSDate(){
		return sDate;
	}
	
	public void setSDate(String sDate){
		
		this.sDate = sDate;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getSmallTitle(){
		return smallTitle;
	}
	
	public void setSmallTitle(String smallTitle){
		this.smallTitle= smallTitle;
	}

	public int getCode(){
		return code;
	}

	public String getIntro(){
		return intro;
	}
	
	public void setIntro(String intro){
		this.intro = intro;
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
	/*
	 *编码后文本内容
	 */
	public String getTerm(){
		return term;
	}
}
