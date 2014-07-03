package org.guohai.blog;

import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.guohai.blog.bll.ContactBLL;
import org.guohai.blog.dao.ContactDAO;
import org.guohai.blog.model.Contact;
import org.guohai.util.HttpXmlClient;
import org.markdownj.MarkdownProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	private static ContactDAO contactDAO;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		Date date = new Date();
		contactDAO = new ContactDAO();
		List<Contact> list = contactDAO.selectAll();
		model.addAttribute("list", list);
		model.addAttribute("curYear", date.getYear() + 1);
		return "home";
	}
	
	
	@RequestMapping(value="/{year}/{month}/{day}/{smallTitle}", method = RequestMethod.GET)
	public String contact(@PathVariable("year") int year,@PathVariable("month") int month,
			@PathVariable("day") int day,@PathVariable("smallTitle") String smallTitle, Model model) {
		logger.info("contact intpu url :"+year+"/"+month+"/"+day+"/"+smallTitle);
	
		Contact contact = new ContactBLL().GetContactBySmallTitle(year, month, day, smallTitle);
		logger.info("blogid title :"+contact.getIntro());
		contact.setIntro(new MarkdownProcessor().markdown(contact.getIntro()));
		model.addAttribute("contact", contact);
		Contact contactLast = contactDAO.selectByLast(contact.getCode());
		model.addAttribute("contactLast", contactLast);
		Contact contactNext = contactDAO.selectByNext(contact.getCode());
		model.addAttribute("contactNext", contactNext);
		return "contact";
	}
}
