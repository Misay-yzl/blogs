package com.blogs.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blogs.dao.Blogs_commentDao;
import com.blogs.entity.Blogs_comment;
import com.blogs.utils.BaseDao;

public class Blogs_commentDaoImp implements Blogs_commentDao {
	private BaseDao bd=new BaseDao();//创建连接mysql帮助类
	@Override
	public List<Blogs_comment> select_blogs_comment(String id) {
		String sql="SELECT bau.headAddress,bc.`id`,bar.`id` blogsId,bau.`author`,bc.`content`,bc.`release_time` FROM blogs_comment bc,blogs_author bau,`blogs_article` bar WHERE bc.`authorId`=bau.`id` AND bar.`id`=bc.`blogsId` AND bc.`flag`=1 AND bar.`id`=?";
		List<Blogs_comment> list=new ArrayList<Blogs_comment>();
		ResultSet rs=bd.executeQuery(sql, id);
		try {
			while (rs.next()) {
				int id2=rs.getInt("id");
				int blogsId=rs.getInt("blogsId");
				String author=rs.getString("author");
				String content=rs.getString("content");
				String release_time=rs.getString("release_time");
				String head=rs.getString("headAddress");
				Blogs_comment bc=new Blogs_comment(id2, blogsId, author, content, release_time,head);
				list.add(bc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean send_blogs_comment(Blogs_comment bc) {
		String sql="INSERT INTO blogs_comment VALUES(0,?,(SELECT id FROM `blogs_author` WHERE author=?),?,NOW(),1)";
		int row=bd.executeUpdate(sql, bc.getBlogsId(),bc.getAuthor(),bc.getContent());
		return row>0?true:false;
	}
	@Override
	public boolean del_blogs_comment(int id) {
		String sql="UPDATE `blogs_comment` SET flag=0 WHERE id=?";
		int row=bd.executeUpdate(sql, id);
		return row>0?true:false;
	}

}
