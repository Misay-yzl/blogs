package com.blogs.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LogoutSession")
public class Servlet_LogoutSession extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Enumeration em = req.getSession().getAttributeNames();
	     while(em.hasMoreElements()){
	    	 req.getSession().removeAttribute(em.nextElement().toString());
	    }
	 	PrintWriter out=resp.getWriter();
		out.write("<script>");
		out.write("location.replace(document.referrer)");
		out.write("</script>");
		out.flush();
		out.close();     
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
