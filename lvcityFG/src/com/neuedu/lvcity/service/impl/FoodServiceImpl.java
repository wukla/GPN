package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.FoodDao;
import com.neuedu.lvcity.dao.IndexDao;
import com.neuedu.lvcity.dao.impl.FoodDaoImpl;
import com.neuedu.lvcity.dao.impl.IndexDaoImpl;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.service.FoodService;
import com.neuedu.lvcity.service.IndexService;

public class FoodServiceImpl  implements FoodService{
	/**
	 * 类实例
	 */
	private static final  FoodService instance = new FoodServiceImpl();

	/**
	 * 取得实例
	 * 
	 * @return 实例对象
	 */
	public static FoodService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private FoodServiceImpl() {
	}

	@Override
	public int getCountByFtid(int ftid) {
		    //声明数据库连接对象，用于保存数据库连接对象
				Connection conn = null;
				//声明变量，用于保存数据库查询结果
				int result = 0;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn = DBUtils.getConnection();
					//创建FoodDao的实现类对象
					FoodDao foodDao = new FoodDaoImpl(conn);
					//调用dao中的.getCountByFtid(ftid方法，进行数据库查询操作，结果赋值给查询结果变量
					result = foodDao.getCountByFtid(ftid);
				
				} catch (Exception e) {
					//将异常封装成自定义异常并抛出
					throw new ServiceException("查询所有food错误", e);
				} finally {
					//调用数据库工具类的closeConnection方法，关闭连接
					DBUtils.closeConnection(conn);
				}
				//返回数据库查询结果
				return result;
	}

	@Override
	public List<Food> foodListByFtid(int ftid, int start) {
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn = null;
				//声明变量，用于保存数据库查询结果
				List<Food> foods = null;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn = DBUtils.getConnection();
					//创建FoodDao的实现类对象
					FoodDao foodDao = new FoodDaoImpl(conn);
					//调用dao中的foodListByFtid(ftid, start）方法，进行数据库查询操作，结果赋值给查询结果变量
					foods = foodDao.foodListByFtid(ftid, start);
				
				} catch (Exception e) {
					//将异常封装成自定义异常并抛出
					throw new ServiceException("查询所有banar错误", e);
				} finally {
					//调用数据库工具类的closeConnection方法，关闭连接
					DBUtils.closeConnection(conn);
				}
				//返回数据库查询结果
				return foods;
	}

	@Override
	public int getCountByLike(String like, int ftid) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		int result = 0;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建FoodDao的实现类对象
			FoodDao foodDao = new FoodDaoImpl(conn);
			//调用dao中的.getCountByFtid(ftid方法，进行数据库查询操作，结果赋值给查询结果变量
			result = foodDao.getCountByLike(like, ftid);
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有food错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return result;
	}

	@Override
	public List<Food> foodListByLike(String like, int ftid, int start) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		List<Food> foods = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建FoodDao的实现类对象
			FoodDao foodDao = new FoodDaoImpl(conn);
			//调用dao中的foodListByFtid(ftid, start）方法，进行数据库查询操作，结果赋值给查询结果变量
			foods = foodDao.foodListByLike(like, ftid, start);
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有banar错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return foods;
	}

}
