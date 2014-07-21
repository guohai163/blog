package org.guohai.blog.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.guohai.blog.model.User;
import org.guohai.util.GHMemcached;




public class UserDAO {
	private SqlSessionFactory sqlSessionFactory;
	 
    public UserDAO(){
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }
    
    public User selectByUserName(String userName){
    	SqlSession session = sqlSessionFactory.openSession();

		try {
			User user = (User) session.selectOne("User.getByUserName",userName);
			return user;
		} finally {
			session.close();
		}
    }
    
    public User selectByUserNameFromMemcached(String userName){
    	GHMemcached client = GHMemcached.getInstance();

		return (User) client.get("account|"+userName);

    	
    }
    
    public void insertByUserNameFromMemcached(User user){
    	GHMemcached client = GHMemcached.getInstance();
    	

		client.set("account|"+user.getUserName(), 60*60*24, user);

    }
}
