package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.IndexDao;
import com.neuedu.lvcity.dao.impl.IndexDaoImpl;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.Scenic;
import com.neuedu.lvcity.service.IndexService;

public class IndexServiceImpl implements IndexService {
	
	/**
	 * 类实例
	 */
	private static final  IndexService instance = new IndexServiceImpl();

	/**
	 * 取得实例
	 * 
	 * @return 实例对象
	 */
	public static IndexService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private IndexServiceImpl() {
	}

	@Override
	public List<Banar> findBanar() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<Banar> banars = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建indexDao的实现类对象
			IndexDao indexDao = new IndexDaoImpl(conn);
			//调用dao中的findBanar方法，进行数据库查询操作，结果赋值给查询结果变量
			banars = indexDao.findBanar();
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有banar错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return banars;
	}

	@Override
	public List<Article> findIndexArticle() {
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn = null;
				//声明变量，用于保存数据库查询结果
				List<Article > articles = null;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn = DBUtils.getConnection();
					//创建indexDao的实现类对象
					IndexDao indexDao = new IndexDaoImpl(conn);
					//调用dao中的findIndexArticle方法，进行数据库查询操作，结果赋值给查询结果变量
					articles = indexDao.findIndexArticle();	
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有articles错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return articles;
	}

	@Override
	public List<Scenic> findIndexScenic() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<Scenic> scenics = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建IndexDao的实现类对象
			IndexDao indexDao = new IndexDaoImpl(conn);
			//调用dao中的selectAll方法，进行数据库查询操作，结果赋值给查询结果变量
			scenics = indexDao.findIndexScenic();		
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有scenics错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return scenics;
	}

	@Override
	public List<Food> findIndexFood() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<Food> foods = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建IndexDao的实现类对象
			IndexDao indexDao = new IndexDaoImpl(conn);
			//调用dao中的selectAll方法，进行数据库查询操作，结果赋值给查询结果变量
			foods =indexDao.findIndexFood();			
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有Food错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return foods;
	}

}
