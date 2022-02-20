package com.blogs.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.blogs.dao.Blogs_authorDao;
import com.blogs.entity.Blogs_author;
import com.blogs.utils.BaseDao;

public class Blogs_authorDaoImp implements Blogs_authorDao {
	private BaseDao bd=new BaseDao();
	@Override
	public boolean findByUser(String author,String pwd) {
		String sql="SELECT COUNT(1) FROM `blogs_author` WHERE author=? AND PASSWORD=?";
		int row=bd.executeQueryCount(sql, author,pwd);
		return row>0?true:false;
	}
	@Override
	public boolean insertUser(Blogs_author bau) {
		String sql="INSERT INTO blogs_author VALUE(0,?,?,?,?)";
		int row=bd.executeUpdate(sql, bau.getAuthor(),bau.getPassword(),bau.getEmail(),bau.getHeadAddress());
		return row>0?true:false;
	}
	@Override
	public boolean selectAuthor(String author) {
		String sql="SELECT COUNT(1) FROM `blogs_author` WHERE `author`=?";
		int row=bd.executeQueryCount(sql, author);
		return row>0?true:false;
	}
	@Override
	public boolean selectEmail(String email,String author) {
		String sql="SELECT COUNT(1) FROM `blogs_author` WHERE `email`=?";
		if(author==""||author==null){
			int row=bd.executeQueryCount(sql, email);
			return row>0?true:false;
		}else {
			sql+=" and author=?";
			int row=bd.executeQueryCount(sql, email,author);
			return row>0?true:false;
		}
		
	}
	@Override
	public boolean updatePwd(String author, String pwd) {
		String sql="UPDATE blogs_author SET PASSWORD=? WHERE author=?";
		int row=bd.executeUpdate(sql, pwd,author);
		return row>0?true:false;
	}
	@Override
	public int select_AuthorId(String author) {
		String sql="SELECT id FROM `blogs_author` WHERE author=?";
		int id=bd.executeQueryCount(sql, author);
		return id;
	}
	@Override
	public String select_AuthorHead(String author) throws SQLException {
		String sql="select headAddress from blogs_author where author=?";
		ResultSet rs=bd.executeQuery(sql, author);
		String head=null;
		while (rs.next()) {
			 head=rs.getString("headAddress");
		}
		return head;
	}
	@Override
	public boolean update_AuthorHead(String author, String head) {
		String sql="update blogs_author set headAddress=? where author=?";
		int row=bd.executeUpdate(sql, head,author);
		return row>0?true:false;
	}
	
}
