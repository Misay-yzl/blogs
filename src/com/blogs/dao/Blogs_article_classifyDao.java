package com.blogs.dao;

import java.util.List;

import com.blogs.entity.Blogs_classify;

/**
 * 分类操作
 * @author Administrator
 *
 */
public interface Blogs_article_classifyDao {
	/**
	 * 查询所有分类
	 * @return
	 */
	List<Blogs_classify> selectAllClassify();
	/**
	 * 查询分类是否存在
	 * @param classify
	 * @return
	 */
	boolean select_classify(String classify);
	/**
	 * 新增分类
	 * @param classify
	 * @return
	 */
	boolean insert_classify(String classify);
	/**
	 * 查询分类id
	 * @param classify
	 * @return
	 */
	int select__ClassifyId(String classify);
}
