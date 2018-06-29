package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.ArticleDao;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Contact;

public class ArticleDaoImpl implements ArticleDao{
	/**
	 * 数据库连接
	 */
	private Connection conn;

	/**
	 * 构造方法
	 * 
	 * @param conn
	 *            数据库连接
	 */
	public ArticleDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Article getArticleById(int aid) {
		   
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		Article article = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement(" select * from article where aid = ?");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量		
			pstam.setInt(1, aid);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
			while(rs.next()){
				article = new Article();
				article.setAid(rs.getInt("aid"));
				article.setAtid(rs.getInt("atid"));
				article.setPublisher(rs.getInt("publisher"));
				article.setContent(rs.getString("content"));
				article.setImage(rs.getString("image"));
				article.setArticlename(rs.getString("articlename"));
				article.setReleasetime(rs.getString("releasetime"));					
			}			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询全部article的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return article;
	}

	@Override
	public List<Article> findHistoricArticle() {
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		List<Article> articles = new ArrayList<Article>();
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement(" select * from article where atid = 1 ORDER BY aid DESC");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量				
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
			while(rs.next()){
				Article article = new Article();
				article.setAid(rs.getInt("aid"));
				article.setAtid(rs.getInt("atid"));
				article.setPublisher(rs.getInt("publisher"));
				article.setContent(rs.getString("content"));
				article.setImage(rs.getString("image"));
				article.setReleasetime(rs.getString("releasetime"));		
				articles.add(article);
			}			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询全部article的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return articles;
	}

	@Override
	public int findHistorcCount() {
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		int result = 0;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement(" select count(*) from article where atid = 1");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量				
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
			while(rs.next()){
				result = rs.getInt("count(*)");
			}			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询全部article的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return result;
	}

}
