package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.common.ServiceException;
import com.neuedu.lvcity.dao.ContactDao;
import com.neuedu.lvcity.dao.IndexDao;
import com.neuedu.lvcity.dao.impl.ContactDaoImpl;
import com.neuedu.lvcity.dao.impl.IndexDaoImpl;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Contact;
import com.neuedu.lvcity.service.ContactService;
import com.neuedu.lvcity.service.IndexService;

public class ContactServiceImpl  implements ContactService{
	/**
	 * 类实例
	 */
	private static final  ContactService instance = new ContactServiceImpl();

	/**
	 * 取得实例
	 * 
	 * @return 实例对象
	 */
	public static ContactService getInstance() {
		return instance;
	}

	/**
	 * 构造方法
	 */
	private ContactServiceImpl() {
	}

	@Override
	public Contact findContact() {
		//声明数据库连接对象，用于保存数据库连接对象
				Connection conn = null;
				//声明变量，用于保存数据库查询结果
				Contact contact = null;
				try{
					//调用数据库工具类的getConnection方法，取得数据库连接对象，并赋值给数据库连接对象变量
					conn = DBUtils.getConnection();
					//创建ContactDao的实现类对象
					ContactDao contactDao = new ContactDaoImpl(conn);
					//调用dao中的findContact方法，进行数据库查询操作，结果赋值给查询结果变量
					contact =contactDao.findContact();
				
				} catch (Exception e) {
					//将异常封装成自定义异常并抛出
					throw new ServiceException("查询Contact错误", e);
				} finally {
					//调用数据库工具类的closeConnection方法，关闭连接
					DBUtils.closeConnection(conn);
				}
				//返回数据库查询结果
				return contact;
	}

}
