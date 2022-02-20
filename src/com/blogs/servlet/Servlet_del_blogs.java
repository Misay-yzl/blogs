package com.blogs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blogs.service.Blogs_articleService;
import com.blogs.service.imp.Blogs_articleServiceImp;
@WebServlet("/del_blogs")
public class Servlet_del_blogs extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		Blogs_articleService bas=new Blogs_articleServiceImp();
		System.out.println(id);
		int id2=Integer.parseInt(id);
		boolean del=bas.del_blogs(id2);
		PrintWriter out=resp.getWriter();
		out.print(del);
		out.flush();
		out.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
