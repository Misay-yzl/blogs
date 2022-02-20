package com.blogs.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blogs.entity.Blogs_author;
import com.blogs.service.imp.Blogs_authorServiceImp;
/**
 * 新增用户
 * @author Administrator
 *
 */
@WebServlet(urlPatterns="/inserUser",name="inserUser")
public class Servlet_insertUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String author=req.getParameter("author");
		String password=req.getParameter("pwd");
		String email=req.getParameter("email");
		Blogs_author bau=new Blogs_author(0, author, password, email,"默认头像.jpg");
		Blogs_authorServiceImp bausi=new Blogs_authorServiceImp();
		boolean b=bausi.insertUser(bau);
		PrintWriter out=resp.getWriter();
		out.print(b);
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
