package org.guohai.util;

public class Utility {
	public static String GetPageTempleFromDevice(String userAgent,String page){
		if(userAgent.contains("iPhone")){
			return page+"-iphone";
		}else if(userAgent.contains("ipad")){
			return page+"-ipad";
		}
		
		return page;
	}
}
