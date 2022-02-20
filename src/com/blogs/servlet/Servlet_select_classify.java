package com.blogs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blogs.service.Blogs_article_classifyService;
import com.blogs.service.imp.Blogs_article_classifyServiceImp;
@WebServlet("/select_classify")
public class Servlet_select_classify extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String classify=req.getParameter("fenlei");
		Blogs_article_classifyService barcs=new Blogs_article_classifyServiceImp();
		boolean a=barcs.select_classify(classify);
		PrintWriter out=resp.getWriter();
		out.print(a);
		out.flush();
		out.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
