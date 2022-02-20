package com.blogs.dao.imp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blogs.dao.Blogs_article_classifyDao;
import com.blogs.entity.Blogs_classify;
import com.blogs.utils.BaseDao;

public class Blogs_article_classifyDaoImp implements Blogs_article_classifyDao{
	private BaseDao bd=new BaseDao();
	@Override
	public boolean select_classify(String classify) {
		String sql="select count(1) from `blogs_article_classify` where `classify`=?";
		int row=bd.executeQueryCount(sql, classify);
		return row>0?true:false;
	}

	@Override
	public boolean insert_classify(String classify) {
		String sql="INSERT INTO `blogs_article_classify` VALUES(0,?)";
		int row=bd.executeUpdate(sql, classify);
		return row>0?true:false;
	}

	@Override
	public int select__ClassifyId(String classify) {
		String sql="select id from `blogs_article_classify` where `classify`=?";
		int id=bd.executeQueryCount(sql, classify);
		return id;
	}

	@Override
	public List<Blogs_classify> selectAllClassify(){
		String sql="SELECT * FROM `blogs_article_classify`";
		List<Blogs_classify> list=new ArrayList<Blogs_classify>();
		ResultSet rs=bd.executeQuery(sql);
		try {
			while (rs.next()) {
				int id=rs.getInt(1);
				String classify=rs.getString(2); 
				Blogs_classify bc=new Blogs_classify(id, classify);
				//System.out.println(bc.getId()+"  "+bc.getClassify());
				list.add(bc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
