package com.blogs.dao;

import java.util.List;

import com.blogs.entity.Blogs_comment;

/**
 * 评论操作
 * @author Administrator
 *
 */
public interface Blogs_commentDao {
	/**
	 * 根据博客id查询评论
	 * @param parentId
	 * @return
	 */
	List<Blogs_comment> select_blogs_comment(String id);
	/**
	 * 发送评论
	 * @param bc
	 * @return
	 */
	boolean send_blogs_comment(Blogs_comment bc);
	/**
	 * 删除评论
	 * @param id
	 * @return
	 */
	boolean del_blogs_comment(int id);
}
