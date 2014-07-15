package org.guohai.blog;

import java.util.Locale;

import org.guohai.blog.bll.ContactBLL;
import org.guohai.blog.model.Contact;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ManageController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
	@RequestMapping(value = "/add-contact/", method = RequestMethod.POST)
	public String AddContact(@RequestBody String requestBody) {
		logger.info(requestBody);
		//Contact contact = new Contact();
		//ContactBLL  contactBll = new ContactBLL();
		//contactBll.AddPost();
		return "manage/add-contact";
	}
	
	@RequestMapping(value="/add-contact/",method = RequestMethod.GET)
	public String AddContact(){
		return "manage/add-contact";
	}
}
