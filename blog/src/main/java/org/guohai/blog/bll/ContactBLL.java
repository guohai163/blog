package org.guohai.blog.bll;

import java.util.Date;
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
	/**
	 * 通过时间和短标题获取文章详细内容
	 * @param year
	 * @param month
	 * @param day
	 * @param smallTitle
	 * @return
	 */
	public Contact GetContactBySmallTitle(int year,int month,int day,String smallTitle){
		contactDAO= new ContactDAO();
		Contact contact = new Contact();
		contact.setSDate(year+"-"+month+"-"+day);
		contact.setSmallTitle(smallTitle);
		return contactDAO.selectByYMDandSmallTitle(contact);
	}
	
	/**
	 * 获取公有博客数量
	 * @return
	 */
	public int GetPublishPostPageCount(){
		contactDAO = new ContactDAO();
		return contactDAO.selectPostCount()/10+1;
	}
	
	/**
	 * 
	 * @param contact
	 */
	public void AddPost(Contact contact){
		contact.setDate(new Date());
		contactDAO=new ContactDAO();
		contactDAO.insertPost(contact);
	}
	

}
