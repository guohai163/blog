package org.guohai.blog.bll;

import java.util.List;

import org.guohai.blog.dao.ContactDAO;
import org.guohai.blog.model.Contact;
import org.guohai.blog.model.PagenateArgs;

public class ContactBLL {

	private static ContactDAO contactDAO;
	
	public List<Contact> GetContactByPage(int pageIndex){
		
		contactDAO= new ContactDAO();
		PagenateArgs page =new PagenateArgs(pageIndex,10);
		return contactDAO.selectByPage(page);
	}
}
