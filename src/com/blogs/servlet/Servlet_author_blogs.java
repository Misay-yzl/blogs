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
import com.blogs.service.Blogs_authorService;
import com.blogs.service.imp.Blogs_articleServiceImp;
import com.blogs.service.imp.Blogs_authorServiceImp;
import com.blogs.utils.BaseDao;
import com.blogs.utils.Page;
@WebServlet("/author_blogs")
public class Servlet_author_blogs extends HttpServlet {
	private BaseDao bd=new BaseDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String author=req.getParameter("author");
		req.setAttribute("zuoz", author);
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
		int zong=bd.executeQueryCount("SELECT COUNT(1) FROM `blogs_article` WHERE author_id=(SELECT id FROM `blogs_author` WHERE author=?) AND flag=1", author);
		int zongye=(zong%7==0?zong/7:zong/7+1)-1;
		if(pageNo>=zongye){
			pageNo=zongye;
		}
		Page page1=new Blogs_articleServiceImp().findBlogs_article(pageNo, 7, author);
		List<Blogs_article> list=page1.getList();
		Blogs_authorService bas=new Blogs_authorServiceImp();
		String headAddress=bas.select_AuthorHead(author);
		req.setAttribute("headAddress", headAddress);
		req.setAttribute("list", list);
		for (Blogs_article blogs_article : list) {
			String time = blogs_article.getWrite_time();
			blogs_article.setWrite_time(time.substring(0, time.length()-2));
			String title=blogs_article.getTitle();
			if(title.length()>24){
				blogs_article.setTitle(title.substring(0, 24)+"...");
			}
			page1.setList(list);
		}
		req.setAttribute("page1", page1);
		req.getRequestDispatcher("author_blogs.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
	

}
