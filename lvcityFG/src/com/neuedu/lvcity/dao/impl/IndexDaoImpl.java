package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.IndexDao;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.Scenic;

public  class  IndexDaoImpl  implements IndexDao {
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
	public IndexDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Banar> findBanar() {
		//声明变量，用于保存查询结果
		List<Banar> list = new ArrayList<Banar>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from banar");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
			while(rs.next()){
			//创建用户对象，用于封装当前游标中的各个字段的值
			Banar banar = new Banar();
			banar.setBannarid(rs.getInt("banarid"));
			banar.setImage(rs.getString("image"));
			banar.setState(rs.getInt("state"));
						
			//声明结果集对象变量，用于保存数据库查询结果
			list.add(banar);
			}	
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询全部banar的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return list;
	}

	@Override
	public List<Article> findIndexArticle() {
		// TODO Auto-generated method stub
		//声明变量，用于保存查询结果
				List<Article> list = new ArrayList<Article>();
				//声明预编译的声明对象变量，用于进行数据库操作的载体
				PreparedStatement pstam = null;
				//声明结果集对象变量，用于保存数据库查询结果
				ResultSet rs = null;
				try {
					//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
					pstam = conn.prepareStatement("select aid,content,image,articlename from article where atid = 1 ORDER BY aid DESC limit 3");
					//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
					rs = pstam.executeQuery();
					//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
					while(rs.next()){
					//创建用户对象，用于封装当前游标中的各个字段的值
					Article article = new Article();
					article.setAid(rs.getInt("aid"));				
					article.setContent(rs.getString("content"));
					article.setImage(rs.getString("image"));
					article.setArticlename(rs.getString("articlename"));
								
					//声明结果集对象变量，用于保存数据库查询结果
					list.add(article);
					}	
				}catch (SQLException e) {
					//如果出现异常，输出异常信息
					System.out.println("在查询全部article的时候出错了.错误信息是 ：" + e.getMessage());			
				} finally {
					//调用数据库工具类，关闭结果集对象和声明对象
					DBUtils.closeStatement(rs, pstam);
				}
			    //返回查询到的用户列表
				return list;
	}

	@Override
	public List<Scenic> findIndexScenic() {
		//声明变量，用于保存查询结果
		List<Scenic> list = new ArrayList<Scenic>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("SELECT * FROM scenic WHERE sid>ROUND((RAND()*(SELECT MAX(sid) FROM scenic where lx='景点'))-3.5,0) LIMIT 7");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
			while(rs.next()){
			//创建用户对象，用于封装当前游标中的各个字段的值
			Scenic scenic = new Scenic();
			scenic.setSid(rs.getInt("sid"));
			scenic.setSname(rs.getString("sname"));
			scenic.setImage(rs.getString("image"));
			scenic.setAid(rs.getInt("aid"));
						
			//声明结果集对象变量，用于保存数据库查询结果
			list.add(scenic);
			}	
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询全部scenic的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return list;
	}

	@Override
	public List<Food> findIndexFood() {
		//声明变量，用于保存查询结果
		List<Food> list = new ArrayList<Food>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("SELECT fid,fname,aid,image FROM food ORDER BY fid DESC LIMIT 6");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
			while(rs.next()){
			//创建用户对象，用于封装当前游标中的各个字段的值
			Food food = new Food();
			food.setFid(rs.getInt("fid"));
			food.setFname(rs.getString("fname"));
			food.setAid(rs.getInt("aid"));
			food.setImage(rs.getString("image"));			
						
			//声明结果集对象变量，用于保存数据库查询结果
			list.add(food);
			}	
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询全部food的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return list;
	}
	
	
}