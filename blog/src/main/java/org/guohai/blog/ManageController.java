package org.guohai.blog;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.guohai.blog.bll.ContactBLL;
import org.guohai.blog.bll.UserBLL;
import org.guohai.blog.model.Contact;
import org.guohai.blog.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping(value="/manage")
public class ManageController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String AddContact(@RequestBody Contact contact,@CookieValue(value = "User-Info") String userUUID) {
		logger.debug("title is:"+contact.getTitle());
		logger.debug("user uuid:"+userUUID);
		//Get User Model
		UserBLL userbll = new UserBLL();
		User userModel = userbll.GetUserInfoByMemcached(userUUID);
		if(userModel==null || userModel.getCode()==0){
			return "manage/login";
		}
		
		
		//Contact contact = new Contact();
		ContactBLL  contactBll = new ContactBLL();
		
		
		contactBll.AddPost(contact);
		return "manage/add-contact";
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String AddContact(){
		return "manage/add-contact";
	}
	
	@RequestMapping(value="/login" , method = RequestMethod.GET)
	public String LoginContact(){
		return "manage/login";
	}
	
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public String LoginContact(@RequestParam(value="username") String userName,
			@RequestParam(value="password") String password,
			HttpServletResponse response,Model model){
		logger.debug("username:"+userName);
		UserBLL userBll = new UserBLL();
		User user = userBll.CheckUserLogin(userName, password);
		
		if(user != null){
			response.addCookie(new Cookie("User-Info",userBll.loginWriteCookie(user)));
			return "manage/add-contact";
		}
		return "manage/login";
	}
}
