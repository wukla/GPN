package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.Food;

public interface FoodDao {
	
	//按美食分类查找此分类下的美食数量
	public int getCountByFtid(int ftid);
	//按美食分类查找此分类下的美食集合,从第start条开始
	public List<Food> foodListByFtid(int ftid,int start);
	
	//统计满足模糊查询数量
	public int getCountByLike(String like,int ftid);
	//查询满足模糊查询的食物集合
	public List<Food> foodListByLike(String like,int ftid,int start);
	
}
