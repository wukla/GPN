package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.ArticleDao;
import com.neuedu.lvcity.dao.FoodDao;
import com.neuedu.lvcity.dao.impl.ArticleDaoImpl;
import com.neuedu.lvcity.dao.impl.FoodDaoImpl;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.service.ArticleService;
import com.neuedu.lvcity.service.FoodService;

public class ArticleServiceImpl implements ArticleService{
	/**
	 * 类实例
	 */
	private static final  ArticleService instance = new ArticleServiceImpl();

	/**
	 * 取得实例
	 * 
	 * @return 实例对象
	 */
	public static ArticleService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private ArticleServiceImpl() {
	}
	@Override
	public Article getArticleById(int aid) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		Article article = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建ArticleDao的实现类对象
			ArticleDao articleDao = new ArticleDaoImpl(conn);
			//调用dao中的.getCountByFtid(ftid方法，进行数据库查询操作，结果赋值给查询结果变量
			article = articleDao.getArticleById(aid);
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有article错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return article;
	}

	@Override
	public List<Article> findHistoricArticle() {
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn = null;
				//声明变量，用于保存数据库查询结果
				List<Article> articles = new ArrayList<Article>();
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn = DBUtils.getConnection();
					//创建ArticleDao的实现类对象
					ArticleDao articleDao = new ArticleDaoImpl(conn);
					//调用dao中的.getCountByFtid(ftid方法，进行数据库查询操作，结果赋值给查询结果变量
					articles = articleDao.findHistoricArticle();
				
				} catch (Exception e) {
					//将异常封装成自定义异常并抛出
					throw new ServiceException("查询所有article错误", e);
				} finally {
					//调用数据库工具类的closeConnection方法，关闭连接
					DBUtils.closeConnection(conn);
				}
				//返回数据库查询结果
				return articles;
	}

	@Override
	public int findHistorcCount() {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		int result = 0;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建ArticleDao的实现类对象
			ArticleDao articleDao = new ArticleDaoImpl(conn);
			//调用dao中的.getCountByFtid(ftid方法，进行数据库查询操作，结果赋值给查询结果变量
			result = articleDao.findHistorcCount();
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有article错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return result;
	}

}
