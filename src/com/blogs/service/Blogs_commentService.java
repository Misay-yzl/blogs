package com.blogs.service;

import java.util.List;

import com.blogs.entity.Blogs_comment;

public interface Blogs_commentService {
	/**
	 * ���ݲ���id��ѯ����
	 * @param parentId
	 * @return
	 */
	List<Blogs_comment> select_blogs_comment(String id);
	/**
	 * ��������
	 * @param bc
	 * @return
	 */
	boolean send_blogs_comment(Blogs_comment bc);
}
