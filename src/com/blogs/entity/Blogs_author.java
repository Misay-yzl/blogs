package com.blogs.entity;

public class Blogs_author {
	private int id; //编号
	private String author;//用户名/作者
	private String password;//密码
	private String email;//邮箱
	private String headAddress;//头像地址
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
