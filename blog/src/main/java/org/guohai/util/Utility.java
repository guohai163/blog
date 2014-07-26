package org.guohai.util;

public class Utility {
	public static String GetPageTempleFromDevice(String userAgent,String page){
		if(userAgent.contains("iPhone")){
			return page+"-iphone";
		}		
		return page;
	}
}
