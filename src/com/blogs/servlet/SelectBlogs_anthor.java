package com.blogs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blogs.service.Blogs_authorService;
import com.blogs.service.imp.Blogs_authorServiceImp;
@WebServlet(urlPatterns="/SelectBlogs_anthor",name="SelectBlogs_anthor")
public class SelectBlogs_anthor extends HttpServlet{
	private Blogs_authorService bas=new Blogs_authorServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String author=req.getParameter("author");
		String pwd=req.getParameter("pwd");
		boolean flag = bas.findByUser(author, pwd);
		String head=bas.select_AuthorHead(author);
		if(flag){
			
			req.getSession().setAttribute("author", author);
			req.getSession().setAttribute("head", head);
			
			// cookie里面只能保存String，不能保存汉字，非要保存用URLEncoder编码
			/*Cookie cookie1 = new Cookie("username", author);
			Cookie cookie2 = new Cookie("password", pwd);
			resp.addCookie(cookie1);
			resp.addCookie(cookie2);*/
			
			/*StringBuffer url=req.getRequestURL();
			System.out.println(url);*/
//			resp.sendRedirect("index.jsp");
//			PrintWriter out=resp.getWriter();
//			out.write("<script>");
//			out.write("window.location.go(-2)");
//			out.write("</script>");
//			out.flush();
//			out.close();
			PrintWriter out=resp.getWriter();
			out.print(flag);
			out.flush();
			out.close();
		}else{
			PrintWriter out=resp.getWriter();
			out.print(flag);
			out.flush();
			out.close();
		}
	}
	
	
}
