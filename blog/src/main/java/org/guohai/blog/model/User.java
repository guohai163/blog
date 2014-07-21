package org.guohai.blog.model;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int code;
	private String userName;
	private String password;
	private String passKey;
	
	public int getCode(){
		return code;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getPassKey(){
		return passKey;
	}
}
