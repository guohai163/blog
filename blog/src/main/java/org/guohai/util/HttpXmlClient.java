package org.guohai.util;

import org.apache.wink.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpXmlClient {

	private static final Logger logger = LoggerFactory.getLogger(HttpXmlClient.class);

	
	@SuppressWarnings("finally")
	public static String GetUUID(){
		logger.info("getid");
		RestClient client = new RestClient();
		
		Resource resource = client.resource("http://uuid.gyyx.cn");
		String response="";
		try{
			response = resource.accept("text/plain").get(String.class).replace("\"", "");

			logger.debug("getuuid:"+response);
		}finally{
			return response;
		}
		
	}
  
}
