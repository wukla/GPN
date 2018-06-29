package com.neuedu.lvcity.dao;

import com.neuedu.lvcity.model.Admin;

public interface AdminDao {
	//根据adminid 获取发布人信息
			public Admin getAdminById(int adminId);
}
