package com.blogs.service.imp;

import java.sql.SQLException;

import com.blogs.dao.Blogs_authorDao;
import com.blogs.dao.imp.Blogs_authorDaoImp;
import com.blogs.entity.Blogs_author;
import com.blogs.service.Blogs_authorService;

public class Blogs_authorServiceImp implements Blogs_authorService {
	private Blogs_authorDao bad=new Blogs_authorDaoImp();
	
	@Override
	public boolean findByUser(String author, String pwd) {
		return bad.findByUser(author, pwd);
	}

	@Override
	public boolean insertUser(Blogs_author bau) {
		return bad.insertUser(bau);
	}

	@Override
	public boolean selectAuthor(String author) {
		return bad.selectAuthor(author);
	}

	@Override
	public boolean selectEmail(String email,String author) {
		return bad.selectEmail(email,author);
	}

	@Override
	public boolean updatePwd(String author, String pwd) {
		return bad.updatePwd(author, pwd);
	}

	@Override
	public String select_AuthorHead(String author) {
		try {
			return bad.select_AuthorHead(author);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update_AuthorHead(String author, String head) {
		return bad.update_AuthorHead(author, head);
	}

}
