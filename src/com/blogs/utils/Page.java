package com.blogs.utils;

import java.util.List;

import com.blogs.entity.Blogs_article;


public class Page {
	private int pageNo;  		//��ǰҳ
	private int totalCount; 	//�ܼ�¼��
	private int totalPageCount; //��ҳҳ��
	private int pageSize=8; 	//ҳ���С
	private List<Blogs_article> list;	//ҳ������
	public Page() {
	}
	public Page(int pageNo, int totalCount, int totalPageCount, int pageSize, List<Blogs_article> list) {
		super();
		this.pageNo = pageNo;
		this.totalCount = totalCount;
		this.totalPageCount = totalPageCount;
		this.pageSize = pageSize;
		this.list = list;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		setTotalPageCount();
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	private void setTotalPageCount() {
		//�ܼ�¼��-ҳ���С
		this.totalPageCount=totalCount%pageSize==0?
							(totalCount/pageSize):
							(totalCount/pageSize)+1;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize<=0){
			this.pageSize=10;
		}
		this.pageSize = pageSize;
		setTotalPageCount();
	}
	public List<Blogs_article> getList() {
		return list;
	}
	public void setList(List<Blogs_article> list) {
		this.list = list;
	}
	
}
