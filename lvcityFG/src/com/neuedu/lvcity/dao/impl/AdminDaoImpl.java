package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.AdminDao;
import com.neuedu.lvcity.model.Admin;
import com.neuedu.lvcity.model.Contact;

public class AdminDaoImpl implements AdminDao{
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
	public AdminDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Admin getAdminById(int adminId) {
	
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		Admin admin = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from admin_ where adminid = ?");  //表名不要用admin，关键字冲突
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量	
			pstam.setInt(1, adminId);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段	
			
			if(rs.next()){
				 admin = new Admin();
				 admin.setAdminid(rs.getInt("adminid"));
				 admin.setAdminname(rs.getString("adminname"));
				 admin.setPasswd(rs.getString("passwd"));
				
			}			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询admin的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return admin;
	}

}
