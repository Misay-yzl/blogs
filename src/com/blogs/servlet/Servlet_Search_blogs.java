package com.blogs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blogs.entity.Blogs_article;
import com.blogs.service.Blogs_articleService;
import com.blogs.service.imp.Blogs_articleServiceImp;
import com.blogs.utils.Page;
@WebServlet("/search_blogs")
public class Servlet_Search_blogs extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title2=req.getParameter("name1");
		req.setAttribute("title", title2);
		String pageNo1=req.getParameter("pageNo");
		
		int pageNo=0;
		if(pageNo1==""||pageNo1==null){
			pageNo1="0";
		}else {
			pageNo=Integer.parseInt(pageNo1);
			if(pageNo<0){
				pageNo=0;
			}
		}
		int zong=new Blogs_articleServiceImp().getTotalCount(title2);
		int zongye=(zong%7==0?zong/7:zong/7+1)-1;
		if(pageNo>=zongye){
			pageNo=zongye;
		}
		boolean ti = title2.contains("%");//判断标题中是否有%
		if(ti)title2=title2.replace("%","\\%");
		Page page1=new Blogs_articleServiceImp().findbyTile_blogs(pageNo, 7, title2);
		//System.out.println(page1.getTotalPageCount());
		List<Blogs_article> list=page1.getList();
		for (Blogs_article blogs_article : list) {
			String time = blogs_article.getWrite_time();
			blogs_article.setWrite_time(time.substring(0, 10));

			String content = blogs_article.getContent();
			if (content.length() > 20) {
				blogs_article.setContent(content.substring(0, 20)+"...");
			}
			String title=blogs_article.getTitle();
			if(title.length()>24){
				blogs_article.setTitle(title.substring(0, 24)+"...");
			}
			page1.setList(list);
		}
		
		req.setAttribute("page1", page1);
		req.getRequestDispatcher("search_blogs.jsp").forward(req, resp);	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
