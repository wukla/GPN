package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.FoodTypeDao;
import com.neuedu.lvcity.model.FoodType;


public class FoodTypeDaoImpl  implements FoodTypeDao{
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
	public FoodTypeDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<FoodType> findFoodtype() {
		//声明变量，用于保存查询结果
				List<FoodType> foodTypes = new ArrayList<FoodType>();
				//声明预编译的声明对象变量，用于进行数据库操作的载体
				PreparedStatement pstam = null;
				//声明结果集对象变量，用于保存数据库查询结果
				ResultSet rs = null;
				try {
					//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
					pstam = conn.prepareStatement("select * from foodtype");
					//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
					rs = pstam.executeQuery();
					//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中			
					while(rs.next()){
						FoodType foodType = new FoodType();
						foodType.setFtid(rs.getInt("ftid"));
						foodType.setFt(rs.getString("ft"));
						foodTypes.add(foodType);
					}
				}catch (SQLException e) {
					//如果出现异常，输出异常信息
					System.out.println("在查询foodType的时候出错了.错误信息是 ：" + e.getMessage());			
				} finally {
					//调用数据库工具类，关闭结果集对象和声明对象
					DBUtils.closeStatement(rs, pstam);
				}
			    //返回查询到的用户列表
				return foodTypes;
			}



	@Override
	public String gettypebyid(int ftid) {
		//声明变量，用于保存查询结果
		String result ="";
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select ft from foodtype where ftid = ?");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			pstam.setInt(1,ftid);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的值		
			while(rs.next()){
				result = rs.getString("ft");
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询foodType的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return result;
	}

}
