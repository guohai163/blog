package org.guohai.util;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class GHMemcached {
	private static MemcachedClient memcachedClinet=null;
	private static GHMemcached client=null;
	
	private static final Logger logger = LoggerFactory
			.getLogger(GHMemcached.class);
	
	private GHMemcached(){
		
	}
	
	public static GHMemcached getInstance(){
		if(memcachedClinet == null){
			logger.debug("init memcached client object");
			try {
				memcachedClinet = new XMemcachedClient("192.168.6.192",10001);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(client == null){
			client = new GHMemcached();
		}
		return client;
	}
	
	public Object get(String key){
		try {
			return memcachedClinet.get(key);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void set(String arg0,int arg1,Object arg2){
		try {
			memcachedClinet.set(arg0, arg1, arg2);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
