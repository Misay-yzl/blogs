package com.blogs.service;

import java.sql.SQLException;

import com.blogs.entity.Blogs_author;

public interface Blogs_authorService {
	
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
	  * ��ѯ����ͷ��
	  */
	 String select_AuthorHead(String author);
	 /**
	  * �޸�ͷ��
	  * @param author
	  * @param head
	  * @return
	  */
	 boolean update_AuthorHead(String author,String head);
}
