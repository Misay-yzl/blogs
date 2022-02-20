package com.blogs.service.imp;

import java.util.List;

import com.blogs.dao.Blogs_articleDao;
import com.blogs.dao.imp.Blogs_articleDaoImp;
import com.blogs.entity.Blogs_article;
import com.blogs.service.Blogs_articleService;
import com.blogs.utils.Page;

public class Blogs_articleServiceImp implements Blogs_articleService {
	Blogs_articleDao bard=new Blogs_articleDaoImp();
	@Override
	public int getTotalCount(String title) {
		return bard.getTotalCount(title);
	}
	@Override
	public Page getPage(int pageNo, int pageSize, String author) {
		return bard.getPage(pageNo, pageSize, author);
	}
	@Override
	public Page findBlogs_article(int pageNo, int pageSize,String author) {
		return bard.findBlogs_article(pageNo,pageSize,author);
	}
	@Override
	public Blogs_article findbyid(String id) {
		return bard.findbyid(id);
	}
	@Override
	public boolean send_blogs(Blogs_article bar) {
		return bard.send_blogs(bar);
	}
	@Override
	public boolean update_blogs(Blogs_article bar) {
		return bard.update_blogs(bar);
	}
	@Override
	public boolean del_blogs(int id) {
		return bard.del_blogs(id);
	}
	@Override
	public Page findbyTile_blogs(int pageNo, int pageSize, String title) {
		return bard.findbyTile_blogs(pageNo, pageSize, title);
	}

	
	
	
}
