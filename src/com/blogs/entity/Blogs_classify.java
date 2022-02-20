package com.blogs.entity;

public class Blogs_classify {
	private int id;
	private String classify;
	public Blogs_classify() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blogs_classify(int id, String classify) {
		super();
		this.id = id;
		this.classify = classify;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	
}
