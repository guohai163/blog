package org.guohai.blog;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.guohai.blog.dao.ContactDAO;
import org.guohai.blog.model.Contact;
import org.guohai.util.HttpXmlClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	private static ContactDAO contactDAO;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		logger.info("guid is : {}.", HttpXmlClient.GetUUID());
		/*
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
		*/
		Date date = new Date();
		contactDAO= new ContactDAO();
		List<Contact> list = contactDAO.selectAll();
		model.addAttribute("list", list);
		model.addAttribute("curYear", date.getYear()+1);
		return "home";
	}
	
}
