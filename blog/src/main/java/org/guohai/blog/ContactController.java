package org.guohai.blog;

import java.util.List;

import org.guohai.blog.dao.ContactDAO;
import org.guohai.blog.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="contact")
public class ContactController {

	/**
	 * loger
	 */
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	

	private static ContactDAO contactDAO;
	
	@RequestMapping(value="/blogid/{blogid}")
	public String GetContactFromCode(@PathVariable("blogid") String blogid, Model model){
		logger.info("blogid is :"+blogid);
		

		contactDAO= new ContactDAO();
		
		List<Contact> list = contactDAO.selectAll();
		
		return "contact";
	}
}
