package com.blogs.service;

import java.util.List;

import com.blogs.entity.Blogs_comment;

public interface Blogs_commentService {
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
}
