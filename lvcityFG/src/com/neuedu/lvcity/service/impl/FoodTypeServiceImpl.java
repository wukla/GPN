package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.FoodDao;
import com.neuedu.lvcity.dao.FoodTypeDao;
import com.neuedu.lvcity.dao.IndexDao;
import com.neuedu.lvcity.dao.impl.FoodDaoImpl;
import com.neuedu.lvcity.dao.impl.FoodTypeDaoImpl;
import com.neuedu.lvcity.dao.impl.IndexDaoImpl;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.FoodType;
import com.neuedu.lvcity.service.FoodTypeService;
import com.neuedu.lvcity.service.IndexService;

public class FoodTypeServiceImpl  implements FoodTypeService{
	/**
	 * 类实例
	 */
	private static final  FoodTypeService instance = new FoodTypeServiceImpl();

	/**
	 * 取得实例
	 * 
	 * @return 实例对象
	 */
	public static FoodTypeService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private FoodTypeServiceImpl() {
	}

	@Override
	public List<FoodType> findFoodtype() {
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn = null;
				//声明变量，用于保存数据库查询结果
				List<FoodType> foodTypes = null;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn = DBUtils.getConnection();
					//创建indexDao的实现类对象
					FoodTypeDao foodTypeDao = new FoodTypeDaoImpl(conn);
					//调用dao中的findFoodtype方法，进行数据库查询操作，结果赋值给查询结果变量
					foodTypes =foodTypeDao.findFoodtype();
				
				} catch (Exception e) {
					//将异常封装成自定义异常并抛出
					throw new ServiceException("查询所有foodTypes错误", e);
				} finally {
					//调用数据库工具类的closeConnection方法，关闭连接
					DBUtils.closeConnection(conn);
				}
				//返回数据库查询结果
				return foodTypes;
	}

	@Override
	public String gettypebyid(int ftid) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		String result =  "";
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建indexDao的实现类对象
			FoodTypeDao foodTypeDao = new FoodTypeDaoImpl(conn);
			//调用dao中的findFoodtype方法，进行数据库查询操作，结果赋值给查询结果变量
			result  =foodTypeDao.gettypebyid(ftid);
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("根据ftid查询美食分类名称错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return result;
	}

}
