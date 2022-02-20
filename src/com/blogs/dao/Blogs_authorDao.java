package com.blogs.dao;
import java.sql.SQLException;

import com.blogs.entity.Blogs_author;

/**
 * 用户操作
 * @author Administrator
 *
 */
public interface Blogs_authorDao {
	/**
	 * 查询用户是否存在
	 * @return
	 */
	 boolean findByUser(String author,String pwd);
	 
	 /**
	  * 新增用户
	  * @param bau
	  * @return
	  */
	 boolean insertUser(Blogs_author bau);
	 /**
	  * 查询用户名是否存在
	  * @param author
	  * @return
	  */
	 boolean selectAuthor(String author);
	 /**
	  * 查询邮箱是否存在
	  * @param email
	  * @return
	  */
	 boolean selectEmail(String email,String author);
	 /**
	  * 修改密码
	  * @param author
	  * @param pwd
	  * @return
	  */
	 boolean updatePwd(String author,String pwd);
	 /**
	  * 查询作者id
	  * @param author
	  * @return
	  */
	 int select_AuthorId(String author);
	 /**
	  * 查询作者头像
	  */
	 String select_AuthorHead(String author) throws SQLException;
	 /**
	  * 修改头像
	  * @param author
	  * @param head
	  * @return
	  */
	 boolean update_AuthorHead(String author,String head);
}
