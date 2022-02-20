package com.blogs.dao;
import java.sql.SQLException;

import com.blogs.entity.Blogs_author;

/**
 * �û�����
 * @author Administrator
 *
 */
public interface Blogs_authorDao {
	/**
	 * ��ѯ�û��Ƿ����
	 * @return
	 */
	 boolean findByUser(String author,String pwd);
	 
	 /**
	  * �����û�
	  * @param bau
	  * @return
	  */
	 boolean insertUser(Blogs_author bau);
	 /**
	  * ��ѯ�û����Ƿ����
	  * @param author
	  * @return
	  */
	 boolean selectAuthor(String author);
	 /**
	  * ��ѯ�����Ƿ����
	  * @param email
	  * @return
	  */
	 boolean selectEmail(String email,String author);
	 /**
	  * �޸�����
	  * @param author
	  * @param pwd
	  * @return
	  */
	 boolean updatePwd(String author,String pwd);
	 /**
	  * ��ѯ����id
	  * @param author
	  * @return
	  */
	 int select_AuthorId(String author);
	 /**
	  * ��ѯ����ͷ��
	  */
	 String select_AuthorHead(String author) throws SQLException;
	 /**
	  * �޸�ͷ��
	  * @param author
	  * @param head
	  * @return
	  */
	 boolean update_AuthorHead(String author,String head);
}
