package com.blogs.dao;

import java.util.List;

import com.blogs.entity.Blogs_classify;

/**
 * �������
 * @author Administrator
 *
 */
public interface Blogs_article_classifyDao {
	/**
	 * ��ѯ���з���
	 * @return
	 */
	List<Blogs_classify> selectAllClassify();
	/**
	 * ��ѯ�����Ƿ����
	 * @param classify
	 * @return
	 */
	boolean select_classify(String classify);
	/**
	 * ��������
	 * @param classify
	 * @return
	 */
	boolean insert_classify(String classify);
	/**
	 * ��ѯ����id
	 * @param classify
	 * @return
	 */
	int select__ClassifyId(String classify);
}
