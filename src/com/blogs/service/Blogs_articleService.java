package com.blogs.service;

import java.util.List;

import com.blogs.entity.Blogs_article;
import com.blogs.utils.Page;

public interface Blogs_articleService {
	//获取总记录数
	int getTotalCount(String title);
	//2.查询分页的数据
	Page getPage(int pageNo,int pageSize,String author);
	/**
	 * 查询博客
	 * @param parentId
	 * @return
	 */
	Page findBlogs_article(int pageNo, int pageSize,String author);
	/**
	 * 根据id查询博客
	 * @param id
	 * @return
	 */
	Blogs_article findbyid(String id);
	/**
	 * 发布文章
	 * @param bar
	 * @return
	 */
	boolean send_blogs(Blogs_article bar);
	/**
	 * 修改文章
	 * @param bar
	 * @return
	 */
	boolean update_blogs(Blogs_article bar);
	/**
	 * 删除文章
	 * @param id
	 * @return
	 */
	boolean del_blogs(int id);
	/**
	 * 根据标题模糊查询博客
	 * @param parentId
	 * @return
	 */
	Page findbyTile_blogs(int pageNo, int pageSize,String title);
}
