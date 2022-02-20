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
@WebServlet("/update_blogs")
public class Servlet_update_blogs extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*String title=req.getParameter("title");
		String classify=req.getParameter("fenlei");
		String content=req.getParameter("text");
		content=content.replace("@huanhang","\n");
		String id2=req.getParameter("id");
		int id=Integer.parseInt(id2);
		Blogs_article bar=new Blogs_article(id, title, classify, content, "", "");
		Blogs_articleService bars=new Blogs_articleServiceImp();
		boolean a=bars.update_blogs(bar);
		PrintWriter out=resp.getWriter();
		out.print(a);
		out.flush();
		out.close();*/
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title=req.getParameter("title");
		title=title.replace("@baifenhao","%");
		title=title.replace("@xiaoyuhao","&lt;");
		title=title.replace("@dayuhao","&gt;");
		String classify=req.getParameter("fenlei");
		String content=req.getParameter("text1");
		/*System.out.println(content);
		System.out.println(title);
		System.out.println(classify);*/
		content=content.replace("@huanhang","\n");
		content=content.replace("@baifenhao","%");
		content=content.replace("@TAB","\t");
		content=content.replace("@xiaoyuhao","&lt;");
		content=content.replace("@dayuhao","&gt;");
		String id2=req.getParameter("id");
		int id=Integer.parseInt(id2);
		Blogs_article bar=new Blogs_article(id, title, classify, content, "", "");
		Blogs_articleService bars=new Blogs_articleServiceImp();
		boolean a=bars.update_blogs(bar);
		PrintWriter out=resp.getWriter();
		out.print(a);
		out.flush();
		out.close();
	}
	
}
