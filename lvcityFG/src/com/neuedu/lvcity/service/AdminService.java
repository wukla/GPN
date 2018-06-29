package com.neuedu.lvcity.service;

import com.neuedu.lvcity.model.Admin;

public interface AdminService {
	//根据adminid 获取发布人信息
	public Admin getAdminById(int adminId);
}
