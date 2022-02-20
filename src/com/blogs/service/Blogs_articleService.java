package com.blogs.service;

import java.util.List;

import com.blogs.entity.Blogs_article;
import com.blogs.utils.Page;

public interface Blogs_articleService {
	//��ȡ�ܼ�¼��
	int getTotalCount(String title);
	//2.��ѯ��ҳ������
	Page getPage(int pageNo,int pageSize,String author);
	/**
	 * ��ѯ����
	 * @param parentId
	 * @return
	 */
	Page findBlogs_article(int pageNo, int pageSize,String author);
	/**
	 * ����id��ѯ����
	 * @param id
	 * @return
	 */
	Blogs_article findbyid(String id);
	/**
	 * ��������
	 * @param bar
	 * @return
	 */
	boolean send_blogs(Blogs_article bar);
	/**
	 * �޸�����
	 * @param bar
	 * @return
	 */
	boolean update_blogs(Blogs_article bar);
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	boolean del_blogs(int id);
	/**
	 * ���ݱ���ģ����ѯ����
	 * @param parentId
	 * @return
	 */
	Page findbyTile_blogs(int pageNo, int pageSize,String title);
}
