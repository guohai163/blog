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
    public List<Contact> selectAll(){
 
        SqlSession session = sqlSessionFactory.openSession();
 
        try {
            List<Contact> list = session.selectList("Contact.getAll");
            return list;
        } finally {
            session.close();
        }
    }
}