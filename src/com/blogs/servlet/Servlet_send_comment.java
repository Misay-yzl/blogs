package com.blogs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blogs.entity.Blogs_comment;
import com.blogs.service.Blogs_commentService;
import com.blogs.service.imp.Blogs_commentServiceImp;

@WebServlet("/send_comment")
public class Servlet_send_comment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String blogsId=req.getParameter("blogsId");
		int id=Integer.parseInt(blogsId);
		String author=req.getParameter("author");
		String content=req.getParameter("content");
		content=content.replace("@baifenhao", "%");
		Blogs_comment bc=new Blogs_comment(0, id, author, content, "");
		Blogs_commentService bcs=new Blogs_commentServiceImp();
		boolean flag=bcs.send_blogs_comment(bc);
		PrintWriter out=resp.getWriter();
		out.print(flag);
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	
}
