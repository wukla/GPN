package com.neuedu.lvcity.service.impl;

import java.sql.Connection;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.AdminDao;
import com.neuedu.lvcity.dao.FoodDao;
import com.neuedu.lvcity.dao.impl.AdminDaoImpl;
import com.neuedu.lvcity.dao.impl.FoodDaoImpl;
import com.neuedu.lvcity.model.Admin;
import com.neuedu.lvcity.service.AdminService;
import com.neuedu.lvcity.service.FoodService;

public class AdminServiceImpl implements AdminService {
	/**
	 * 类实例
	 */
	private static final  AdminService instance = new AdminServiceImpl();

	/**
	 * 取得实例
	 * 
	 * @return 实例对象
	 */
	public static AdminService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private AdminServiceImpl() {
	}
	@Override
	public Admin getAdminById(int adminId) {
		//声明数据库连接对象，用于保存数据库连接对象
		Connection conn = null;
		//声明变量，用于保存数据库查询结果
		Admin admin = null;
		try{
			//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
			conn = DBUtils.getConnection();
			//创建AdminDao的实现类对象
			AdminDao adminDao  = new AdminDaoImpl(conn);
			//调用dao中的.getAdminById(adminId)方法，进行数据库查询操作，结果赋值给查询结果变量
			admin  = adminDao.getAdminById(adminId);
		
		} catch (Exception e) {
			//将异常封装成自定义异常并抛出
			throw new ServiceException("查询所有admin错误", e);
		} finally {
			//调用数据库工具类的closeConnection方法，关闭连接
			DBUtils.closeConnection(conn);
		}
		//返回数据库查询结果
		return admin;
	}

}
