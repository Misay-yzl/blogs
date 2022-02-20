package com.blogs.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blogs.entity.Blogs_article;
import com.blogs.entity.Blogs_classify;
import com.blogs.entity.Blogs_comment;
import com.blogs.service.Blogs_articleService;
import com.blogs.service.Blogs_article_classifyService;
import com.blogs.service.Blogs_commentService;
import com.blogs.service.imp.Blogs_articleServiceImp;
import com.blogs.service.imp.Blogs_article_classifyServiceImp;
import com.blogs.service.imp.Blogs_commentServiceImp;

@WebServlet("/select_blogs")
public class Servlet_select_blogs extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		Blogs_articleService bars=new Blogs_articleServiceImp();
		Blogs_article ba=bars.findbyid(id);
		req.setAttribute("blogs", ba);

		List<Blogs_classify> list=new ArrayList<Blogs_classify>();
		Blogs_article_classifyService bacs=new Blogs_article_classifyServiceImp();
		list=bacs.selectAllClassify();
		req.setAttribute("classify", list);
		req.getRequestDispatcher("update_blogs.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
