package com.blogs.entity;

public class Blogs_article {
	
	private int id; //编号
	private String title;//标题
	private String classify;//分类标题
	private String content;//内容
	private String write_time;//写入时间
	private String author;//作者
	private String head;//作者
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public Blogs_article() {
		
	}
	public Blogs_article(int id, String title, String classify, String content, String write_time, String author) {
		super();
		this.id = id;
		this.title = title;
		this.classify = classify;
		this.content = content;
		this.write_time = write_time;
		this.author = author;
	}
	
	
	public Blogs_article(int id, String title, String classify, String content, String write_time, String author,
			String head) {
		super();
		this.id = id;
		this.title = title;
		this.classify = classify;
		this.content = content;
		this.write_time = write_time;
		this.author = author;
		this.head = head;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWrite_time() {
		return write_time;
	}
	public void setWrite_time(String write_time) {
		this.write_time = write_time;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
}
