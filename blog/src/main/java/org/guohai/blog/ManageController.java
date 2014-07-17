package org.guohai.blog;


import org.guohai.blog.bll.ContactBLL;
import org.guohai.blog.model.Contact;
import org.guohai.blog.model.PostContact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value="/manage")
public class ManageController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String AddContact(@RequestBody Contact contact) {
		logger.debug("title is:"+contact.getTitle());
		//Contact contact = new Contact();
		ContactBLL  contactBll = new ContactBLL();
		contactBll.AddPost(contact);
		return "manage/add-contact";
	}
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String AddContact(){
		return "manage/add-contact";
	}
}
