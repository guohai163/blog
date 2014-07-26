package org.guohai.blog.bll;

import org.guohai.blog.dao.UserDAO;
import org.guohai.blog.model.User;
import org.guohai.util.GHMemcached;
import org.guohai.util.HttpXmlClient;
import org.guohai.util.MD5;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserBLL{
	private static UserDAO userDao;
	private static final Logger logger = LoggerFactory
			.getLogger(UserBLL.class);
	public UserBLL()
	{
		UserBLL.userDao = new UserDAO();
		
	}

	public User CheckUserLogin(String userName,String password){
		User user;
		user=userDao.selectByUserNameFromMemcached(userName);
		if(user==null){
			logger.debug("memcached is null by user:"+userName);
			user=userDao.selectByUserName(userName);
			userDao.insertByUserNameFromMemcached(user);
		}
		String md5Password =MD5.GetMD5Code(MD5.GetMD5Code(password)+user.getPassKey());
		
		logger.debug(md5Password);
		if(md5Password.equals(user.getPassword())){
			return user;
		}else{
			return null;
		}
	}
	
	public String loginWriteCookie(User user){
		String userUUID = HttpXmlClient.GetUUID();
		GHMemcached client= GHMemcached.getInstance();
		client.set("CookieInfo|"+userUUID, 60*20, user);
		return userUUID;
	}
	
	public User GetUserInfoByMemcached(String uuid){
		GHMemcached client= GHMemcached.getInstance();
		return (User) client.get("CookieInfo|"+uuid);
	}
}
