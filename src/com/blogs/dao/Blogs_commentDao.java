package com.blogs.dao;

import java.util.List;

import com.blogs.entity.Blogs_comment;

/**
 * ���۲���
 * @author Administrator
 *
 */
public interface Blogs_commentDao {
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
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	boolean del_blogs_comment(int id);
}
