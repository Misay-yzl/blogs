package com.blogs.entity;

public class Blogs_comment {
	private int id;//���
	private int blogsId;//���ͱ��
	private String author;//����
	private String content;//����
	private String release_time;//����ʱ��
	private String head;//����ʱ��
	
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public Blogs_comment() {
		
	}
	public Blogs_comment(int id, int blogsId, String author, String content, String release_time) {
		super();
		this.id = id;
		this.blogsId = blogsId;
		this.author = author;
		this.content = content;
		this.release_time = release_time;
	}
	
	public Blogs_comment(int id, int blogsId, String author, String content, String release_time, String head) {
		super();
		this.id = id;
		this.blogsId = blogsId;
		this.author = author;
		this.content = content;
		this.release_time = release_time;
		this.head = head;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBlogsId() {
		return blogsId;
	}
	public void setBlogsId(int blogsId) {
		this.blogsId = blogsId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRelease_time() {
		return release_time;
	}
	public void setRelease_time(String release_time) {
		this.release_time = release_time;
	}
	
}
