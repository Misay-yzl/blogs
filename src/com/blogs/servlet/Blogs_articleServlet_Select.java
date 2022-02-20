package com.blogs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blogs.entity.Blogs_article;
import com.blogs.entity.Blogs_comment;
import com.blogs.service.Blogs_articleService;
import com.blogs.service.Blogs_commentService;
import com.blogs.service.imp.Blogs_articleServiceImp;
import com.blogs.service.imp.Blogs_commentServiceImp;
import com.blogs.utils.Page;

@WebServlet(urlPatterns = "/selectAllBlogs_article", name = "selectAllBlogs_article")
public class Blogs_articleServlet_Select extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if ("one".equals(action)) {
			String blogs_id = req.getParameter("blogs_id");
			Blogs_articleService barsi = new Blogs_articleServiceImp();
			Blogs_article bar = barsi.findbyid(blogs_id);
			if(bar==null){
				resp.sendRedirect("index.jsp");//如果bar对象为空说明没有查到，就直接返回主页
				return;
			}
			String str = bar.getContent().replace("\n","</br>");
			str=str.replace(" ", "&nbsp;");
			str=str.replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			bar.setContent(str);
			bar.setWrite_time(bar.getWrite_time().substring(0, bar.getWrite_time().length() - 2));
			req.setAttribute("blogs", bar);
			Blogs_commentService bcs=new Blogs_commentServiceImp();
			List<Blogs_comment> list=bcs.select_blogs_comment(blogs_id);
			req.setAttribute("Blogs_commentList", list);
			req.getRequestDispatcher("selectBlogs.jsp").forward(req, resp);
		} else {
			//Blogs_articleService barsi = new Blogs_articleServiceImp();
			//List<Blogs_article> list = barsi.findBlogs_article("");
			// req.getSession().setMaxInactiveInterval(1);//设置存活时间
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
			int zong=new Blogs_articleServiceImp().getTotalCount("");
			int zongye=(zong%7==0?zong/7:zong/7+1)-1;
			if(pageNo>=zongye){
				pageNo=zongye;
			}
			Page page1=new Blogs_articleServiceImp().getPage(pageNo, 7,"");
			//System.out.println(page1.getTotalPageCount());
			List<Blogs_article> list=page1.getList();
			
			//req.setAttribute("list", list);
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
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
