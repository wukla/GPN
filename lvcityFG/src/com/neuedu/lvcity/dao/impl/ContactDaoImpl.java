package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.ContactDao;
import com.neuedu.lvcity.model.Contact;

public class ContactDaoImpl  implements ContactDao{
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
	public ContactDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Contact findContact() {	
		   //声明变量，用于保存查询结果
				Contact contact = null;
				//声明预编译的声明对象变量，用于进行数据库操作的载体
				PreparedStatement pstam = null;
				//声明结果集对象变量，用于保存数据库查询结果
				ResultSet rs = null;
				try {
					//调用连接对象的prepareStatement方法，得到预编译对象，赋值给预编译对象变量
					pstam = conn.prepareStatement(" select * from contact order by contactid desc limit 1");//findContact方法只返回最新录入的数据（一条）
					//调用预编译对象的executeQuery方法，执行查询操作，返回查询结果，赋值给结果集对象变量				
					rs = pstam.executeQuery();
					//如果查询结果不为空，将取出结果集中的各个字段，封装在用户对象的各个属性中，所有对象放到集合中
					while(rs.next()){
						contact = new Contact();
						contact.setAddress(rs.getString("address"));
						contact.setContactid(rs.getInt("contactid"));
						contact.setContactname(rs.getString("contactname"));
						contact.setFax(rs.getString("fax"));
						contact.setQq(rs.getString("qq"));
						contact.setTel(rs.getString("tel"));
						contact.setWeb(rs.getString("web"));
						contact.setZipcode(rs.getString("zipcode"));			
						
					}			
				}catch (SQLException e) {
					//如果出现异常，输出异常信息
					System.out.println("在查询全部banar的时候出错了.错误信息是 ：" + e.getMessage());			
				} finally {
					//调用数据库工具类，关闭结果集对象和声明对象
					DBUtils.closeStatement(rs, pstam);
				}
			    //返回查询到的用户列表
				return contact;
	}

}
