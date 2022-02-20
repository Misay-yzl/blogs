package com.blogs.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blogs.entity.Blogs_classify;
import com.blogs.service.Blogs_article_classifyService;
import com.blogs.service.imp.Blogs_article_classifyServiceImp;
@WebServlet("/selectAllClassify")
public class Servlet_selectAllClassify extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Blogs_classify> list=new ArrayList<Blogs_classify>();
		Blogs_article_classifyService bacs=new Blogs_article_classifyServiceImp();
		list=bacs.selectAllClassify();
		req.setAttribute("classify", list);

		req.getRequestDispatcher("send_blogs.jsp").forward(req, resp);
	
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
