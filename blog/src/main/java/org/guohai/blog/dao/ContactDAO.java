package org.guohai.blog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
 
import org.guohai.blog.model.*;

public class ContactDAO {
	
	private SqlSessionFactory sqlSessionFactory;
	 
    public ContactDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }
    
    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    public List<Contact> selectHomeList(){
 
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            List<Contact> list = session.selectList("Contact.getHomeList");
            return list;
        } finally {
            session.close();
        }
    }
    
	/**
	 * 
	 * @param id
	 * @return
	 */
    public Contact selectById(int id){
    	SqlSession session = sqlSessionFactory.openSession();

		try {
			Contact contact = (Contact) session.selectOne("Contact.getById",id);
			return contact;
		} finally {
			session.close();
		}
    }
    /**
     * 
     * @param pageinfo
     * @return
     */
    public List<Contact> selectByPage(PagenateArgs pageinfo){
    	
    	SqlSession session = sqlSessionFactory.openSession();
    	
    	try{
    		List<Contact> list=session.selectList("Contact.getByPage",pageinfo);
    		return list;
    	}finally{
    		session.close();
    	}
    }
    
    /**
     * 
     * @param code
     * @return
     */
    public Contact selectByNext(int code){
    	SqlSession session = sqlSessionFactory.openSession();
    	
    	try{
    		return session.selectOne("Contact.getNextBlog", code);
    	}finally{
    		session.close();
    	}
    }
    
    /**
     * 
     * @param code
     * @return
     */
    public Contact selectByLast(int code){
    	SqlSession session = sqlSessionFactory.openSession();
    	
    	try{
    		return session.selectOne("Contact.getLastBlog", code);
    	}finally{
    		session.close();
    	}
    }
    
    /**
     * 
     * @param parm
     * @return
     */
    public Contact selectByYMDandSmallTitle(Contact parm){
    	SqlSession session = sqlSessionFactory.openSession();
    	
    	try{
    		return session.selectOne("Contact.getByYMDandSmallTitle", parm);
    	}finally{
    		session.close();
    	}
    }
    
    public int selectPostCount(){
    	SqlSession session = sqlSessionFactory.openSession();
    	
    	try{
    		return session.selectOne("Contact.getPostCount");
    	}finally{
    		session.close();
    	}
    }
}