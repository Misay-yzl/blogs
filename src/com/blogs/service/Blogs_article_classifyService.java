package com.blogs.service;

import java.util.List;

import com.blogs.entity.Blogs_classify;

public interface Blogs_article_classifyService {
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
}
