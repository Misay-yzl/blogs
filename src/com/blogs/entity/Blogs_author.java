package com.blogs.entity;

public class Blogs_author {
	private int id; //���
	private String author;//�û���/����
	private String password;//����
	private String email;//����
	private String headAddress;//ͷ���ַ
	public String getHeadAddress() {
		return headAddress;
	}
	public void setHeadAddress(String headAddress) {
		this.headAddress = headAddress;
	}
	public Blogs_author() {
		super();
	}
	
	public Blogs_author(int id, String author, String password, String email, String headAddress) {
		super();
		this.id = id;
		this.author = author;
		this.password = password;
		this.email = email;
		this.headAddress = headAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
