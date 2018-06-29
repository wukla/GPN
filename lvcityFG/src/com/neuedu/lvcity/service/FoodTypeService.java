package com.neuedu.lvcity.service;

import java.util.List;

import com.neuedu.lvcity.model.FoodType;

public interface FoodTypeService {

	//查询所有美食分类
	public  List<FoodType> findFoodtype();
	
	//根据ftid编号查找美食分类名称
	public String  gettypebyid(int ftid);
}
