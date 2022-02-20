package com.blogs.service.imp;

import java.util.List;

import com.blogs.dao.Blogs_commentDao;
import com.blogs.dao.imp.Blogs_commentDaoImp;
import com.blogs.entity.Blogs_comment;
import com.blogs.service.Blogs_commentService;

public class Blogs_commentServiceImp implements Blogs_commentService {
	private Blogs_commentDao bcd=new Blogs_commentDaoImp();
	@Override
	public List<Blogs_comment> select_blogs_comment(String id) {
		return bcd.select_blogs_comment(id);
	}
	@Override
	public boolean send_blogs_comment(Blogs_comment bc) {
		return bcd.send_blogs_comment(bc);
	}
	
}
