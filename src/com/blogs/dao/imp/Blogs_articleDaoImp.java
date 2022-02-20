package com.blogs.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blogs.dao.Blogs_articleDao;
import com.blogs.entity.Blogs_article;
import com.blogs.utils.BaseDao;
import com.blogs.utils.Page;

public class Blogs_articleDaoImp implements Blogs_articleDao{
	private BaseDao bd=new BaseDao();
	@Override
	public int getTotalCount(String title) {
		String sql="SELECT COUNT(1) FROM blogs_article WHERE flag=1 ";
		int row=0;
		if(title!=""&&title!=null){
			boolean ti = title.contains("%");
			if(!ti){
				sql+="AND title like ?";
				row=bd.executeQueryCount(sql, "%"+title+"%");
			}else{
				title=title.replace("%","\\%");
				sql+="AND title like ?";
				row=bd.executeQueryCount(sql,"%"+title+"%");
			}
		}else{
			row=bd.executeQueryCount(sql);
		}
		return row;	
	}
	@Override
	public Page getPage(int pageNo, int pageSize,String author) {
		Page page=new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		//1.总记录数,总页码,页面大小,当前页,数据
		int totalCount=this.getTotalCount("");
		page.setTotalCount(totalCount);
		
		List<Blogs_article> list=new ArrayList<Blogs_article>();
		String sql="SELECT ban.headAddress,bar.`id`,bar.`title`,bac.classify,bar.`content`,`write_time`,ban.author FROM blogs_article bar,`blogs_author` ban ,`blogs_article_classify` bac WHERE  bar.author_id=ban.id AND bar.classify_id=bac.id and flag=1 ";
		int rowS=page.getPageNo()*page.getPageSize();
		ResultSet rs=null;
		if(author!=""){
			sql+="AND author=? ORDER BY write_time DESC LIMIT ?,?";
			rs=bd.executeQuery(sql, author,rowS,page.getPageSize());
		}else{
			sql+="ORDER BY write_time DESC LIMIT ?,?";
			rs=bd.executeQuery(sql,rowS,page.getPageSize());
		}	
		//ResultSet rs=bd.executeQuery(sql);
		try {
			while (rs.next()) {
				int id=rs.getInt("id");
				String title=rs.getString("title");
				String classify=rs.getString("classify");
				String content=rs.getString("content");
				String write_time=rs.getString("write_time");
				String author1=rs.getString("author");
				String head=rs.getString("headAddress");
				Blogs_article bar=new Blogs_article(id, title, classify, content, write_time, author1,head);
				list.add(bar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		page.setList(list);
		return page;
	}
	@Override
	public Page findBlogs_article(int pageNo, int pageSize,String author) {
		Page page=new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		//1.总记录数,总页码,页面大小,当前页,数据
		int totalCount=bd.executeQueryCount("SELECT COUNT(1) FROM `blogs_article` WHERE author_id=(SELECT id FROM `blogs_author` WHERE author=?) AND flag=1", author);
		page.setTotalCount(totalCount);
		int rowS=page.getPageNo()*page.getPageSize();
		if(rowS<0){
			rowS=0;
		}
		List<Blogs_article> list=new ArrayList<Blogs_article>();
		String sql="SELECT ban.headAddress,bar.`id`,bar.`title`,bac.classify,bar.`content`,`write_time`,ban.author FROM blogs_article bar,`blogs_author` ban ,`blogs_article_classify` bac WHERE  bar.author_id=ban.id AND bar.classify_id=bac.id and flag=1 ";
		
		ResultSet rs=null;
		if(author!=""){
			sql+="AND author=? ORDER BY write_time DESC LIMIT ?,?";
			rs=bd.executeQuery(sql, author,rowS,page.getPageSize());
		}else{
			sql+="ORDER BY write_time DESC LIMIT ?,?";
			rs=bd.executeQuery(sql,rowS,page.getPageSize());
		}	
		//ResultSet rs=bd.executeQuery(sql);
		try {
			while (rs.next()) {
				int id=rs.getInt("id");
				String title=rs.getString("title");
				String classify=rs.getString("classify");
				String content=rs.getString("content");
				String write_time=rs.getString("write_time");
				String author1=rs.getString("author");
				String head=rs.getString("headAddress");
				Blogs_article bar=new Blogs_article(id, title, classify, content, write_time, author1,head);
				list.add(bar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		page.setList(list);
		return page;
	}

	@Override
	public Blogs_article findbyid(String id) {
		String sql="SELECT bar.`id`,bar.`title`,bac.classify,bar.`content`,`write_time`,ban.author FROM blogs_article bar,`blogs_author` ban ,`blogs_article_classify` bac WHERE  bar.author_id=ban.id AND bar.classify_id=bac.id AND bar.id=? AND bar.flag=1";
		ResultSet rs=bd.executeQuery(sql, id);		
		try {
			while (rs.next()) {
				int id3=rs.getInt("id");
				String title=rs.getString("title");
				String classify=rs.getString("classify");
				String content=rs.getString("content");
				String write_time=rs.getString("write_time");
				String author1=rs.getString("author");
				Blogs_article bar=new Blogs_article(id3, title, classify, content, write_time, author1);
				return bar;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean send_blogs(Blogs_article bar) {
		int authorid=new Blogs_authorDaoImp().select_AuthorId(bar.getAuthor());
		//bar.setAuthor(authorid+"");
		int classifyId=new Blogs_article_classifyDaoImp().select__ClassifyId(bar.getClassify());
		//bar.setClassify(classifyId+"");
		String sql="INSERT INTO `blogs_article` VALUES(0,?,?,?,NOW(),?,1)";
		int row=bd.executeUpdate(sql, bar.getTitle(),classifyId,bar.getContent(),authorid);
		return row>0?true:false;
	}

	@Override
	public boolean update_blogs(Blogs_article bar) {
		String sql="UPDATE `blogs_article` SET title=?,classify_id =(SELECT id FROM `blogs_article_classify` WHERE classify=?),content=? WHERE id=?";
		int row=bd.executeUpdate(sql, bar.getTitle(),bar.getClassify(),bar.getContent(),bar.getId());
		return row>0?true:false;
	}

	@Override
	public boolean del_blogs(int id) {
		String sql="UPDATE `blogs_article` SET flag=0 WHERE `id`=?";
		int row=bd.executeUpdate(sql, id);
		return row>0?true:false;
	}

	@Override
	public Page findbyTile_blogs(int pageNo, int pageSize,String title) {
		Page page=new Page();
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		//1.总记录数,总页码,页面大小,当前页,数据
		int totalCount=this.getTotalCount(title);
		page.setTotalCount(totalCount);
		
		List<Blogs_article> list=new ArrayList<Blogs_article>();
		String sql="SELECT ban.headAddress, bar.`id`,bar.`title`,bac.classify,bar.`content`,`write_time`,ban.author FROM blogs_article bar,`blogs_author` ban ,`blogs_article_classify` bac WHERE  bar.author_id=ban.id AND bar.classify_id=bac.id and flag=1 ";
		int rowS=page.getPageNo()*page.getPageSize();
		if(rowS<0){
			rowS=0;
		}
		ResultSet rs=null;
		if(title!=""){
			sql+="AND title like ? ORDER BY write_time DESC LIMIT ?,?";
			rs=bd.executeQuery(sql, "%"+title+"%",rowS,page.getPageSize());
		}else{
			sql+="ORDER BY write_time DESC LIMIT ?,?";
			rs=bd.executeQuery(sql,rowS,page.getPageSize());
		}
		try {
			while (rs.next()) {
				int id=rs.getInt("id");
				String title1=rs.getString("title");
				String classify=rs.getString("classify");
				String content=rs.getString("content");
				String write_time=rs.getString("write_time");
				String author1=rs.getString("author");
				String head=rs.getString("headAddress");
				Blogs_article bar=new Blogs_article(id, title1, classify, content, write_time, author1,head);
				list.add(bar);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		page.setList(list);
		return page;
	}



	
}
