package com.blogs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blogs.service.Blogs_authorService;
import com.blogs.service.imp.Blogs_authorServiceImp;
@WebServlet(urlPatterns="/Selectemail",name="Selectemail")
public class Servlet_Selectemail extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String author=req.getParameter("author");
	/*	if(author!=""){
			Blogs_authorService baus=new Blogs_authorServiceImp();
			boolean au=baus.selectEmail(email,author);
			System.out.println(au);
			PrintWriter out=resp.getWriter();
			out.print(au);
			out.flush();
			out.close();
			
		}else{*/
			Blogs_authorService baus=new Blogs_authorServiceImp();
			boolean au=baus.selectEmail(email,author);

			PrintWriter out=resp.getWriter();
			out.print(au);
			out.flush();
			out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
