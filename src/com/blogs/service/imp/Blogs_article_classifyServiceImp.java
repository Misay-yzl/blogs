package com.blogs.service.imp;
import java.util.List;

import com.blogs.dao.Blogs_article_classifyDao;
import com.blogs.dao.imp.Blogs_article_classifyDaoImp;
import com.blogs.entity.Blogs_classify;
import com.blogs.service.Blogs_article_classifyService;
import com.blogs.utils.BaseDao;

public class Blogs_article_classifyServiceImp implements Blogs_article_classifyService{
	private Blogs_article_classifyDao bac=new Blogs_article_classifyDaoImp();
	@Override
	public boolean select_classify(String classify) {
		return bac.select_classify(classify);
	}
	@Override
	public boolean insert_classify(String classify) {
		return bac.insert_classify(classify);
	}
	@Override
	public List<Blogs_classify> selectAllClassify() {
		return bac.selectAllClassify();
	}

}
