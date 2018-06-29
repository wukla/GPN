package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.FoodDao;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Food;

public class FoodDaoImpl  implements FoodDao{
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
	public FoodDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public int getCountByFtid(int ftid) {
		//声明变量，用于保存查询结果
		int result = 0;
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select count(*) from food where ftid = ?");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			pstam.setInt(1, ftid);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
			while(rs.next()){
				result = rs.getInt("count(*)");
			}			
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询全部food的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return result;
	}

	@Override
	public List<Food> foodListByFtid(int ftid, int start) {
		//声明变量，用于保存查询结果
		List<Food> foods = new ArrayList<Food>();
		//声明预编译的声明对象变量，用于进行数据库操作的载体
		PreparedStatement pstam = null;
		//声明结果集对象变量，用于保存数据库查询结果
		ResultSet rs = null;
		try {
			//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
			pstam = conn.prepareStatement("select * from food where ftid = ? limit  ?,9");
			//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
			pstam.setInt(1, ftid);
			pstam.setInt(2, start);
			rs = pstam.executeQuery();
			//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中			
			while(rs.next()){
				Food food = new Food();
				food.setAid(rs.getInt("aid"));
				food.setFid(rs.getInt("fid"));
				food.setFtid(rs.getInt("ftid"));
				food.setFname(rs.getString("fname"));
				food.setImage(rs.getString("image"));
				foods.add(food);
			}
		}catch (SQLException e) {
			//如果出现异常，输出异常信息
			System.out.println("在查询foods的时候出错了.错误信息是 ：" + e.getMessage());			
		} finally {
			//调用数据库工具类，关闭结果集对象和声明对象
			DBUtils.closeStatement(rs, pstam);
		}
	    //返回查询到的用户列表
		return foods;
	}

	@Override
	public int getCountByLike(String like, int ftid) {
		//声明变量，用于保存查询结果
				int result = 0;
				//声明预编译的声明对象变量，用于进行数据库操作的载体
				PreparedStatement pstam = null;
				//声明结果集对象变量，用于保存数据库查询结果
				ResultSet rs = null;
				try {
					//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
					pstam = conn.prepareStatement("select count(*) from food where fname like ? and  ftid= ?");
					//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
					pstam.setString(1, like);
					pstam.setInt(2, ftid);
					rs = pstam.executeQuery();
					//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
					while(rs.next()){
						result = rs.getInt("count(*)");
						//System.out.println(result);
					}			
				}catch (SQLException e) {
					//如果出现异常，输出异常信息
					System.out.println("在统计满足模糊查询条件的时候出错了.错误信息是 ：" + e.getMessage());			
				} finally {
					//调用数据库工具类，关闭结果集对象和声明对象
					DBUtils.closeStatement(rs, pstam);
				}
			    //返回查询到的用户列表
				return result;
	}

	@Override
	public List<Food> foodListByLike(String like, int ftid, int start) {
		//声明变量，用于保存查询结果
				List<Food> foods = new ArrayList<Food>();
				//声明预编译的声明对象变量，用于进行数据库操作的载体
				PreparedStatement pstam = null;
				//声明结果集对象变量，用于保存数据库查询结果
				ResultSet rs = null;
				try {
					//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
					pstam = conn.prepareStatement("select * from food where fname like ? and ftid =?  limit  ?,9");
					//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量
					pstam.setString(1, like);
					pstam.setInt(2, ftid);
					pstam.setInt(3, start);
					
					rs = pstam.executeQuery();
				
					//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中			
					while(rs.next()){
						Food food = new Food();
						food.setAid(rs.getInt("aid"));
						food.setFid(rs.getInt("fid"));
						food.setFtid(rs.getInt("ftid"));
						food.setFname(rs.getString("fname"));
						food.setImage(rs.getString("image"));
						foods.add(food);
					}
				}catch (SQLException e) {
					//如果出现异常，输出异常信息
					System.out.println("在查询满足模糊条件的foods的时候出错了.错误信息是 ：" + e.getMessage());			
				} finally {
					//调用数据库工具类，关闭结果集对象和声明对象
					DBUtils.closeStatement(rs, pstam);
				}
			    //返回查询到的用户列表
				return foods;
	}

}
