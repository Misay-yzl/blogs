package com.blogs.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.blogs.entity.Blogs_article;
import com.blogs.service.Blogs_articleService;
import com.blogs.service.imp.Blogs_articleServiceImp;
@WebServlet("/send_blogs")
public class Servlet_send_blogs extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title=req.getParameter("title");
		title=title.replace("@baifenhao","%");
		title=title.replace("@xiaoyuhao","&lt;");
		title=title.replace("@dayuhao","&gt;");
		String classify=req.getParameter("fenlei");
		String content=req.getParameter("text");
		String author=req.getParameter("author");
		content=content.replace("@huanhang","\n");
		content=content.replace("@baifenhao","%");
		content=content.replace("@TAB","\t");
		content=content.replace("@xiaoyuhao","&lt;");
		content=content.replace("@dayuhao","&gt;");
		//System.out.println(content);
		Blogs_article bar=new Blogs_article(0, title, classify, content, "2021-01-07", author);
		Blogs_articleService bas=new Blogs_articleServiceImp();
		boolean a=bas.send_blogs(bar);
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
