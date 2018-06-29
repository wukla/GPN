package com.neuedu.lvcity.service;

import java.util.List;

import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.Scenic;

public interface IndexService {
	public List<Banar> findBanar(); //广告大图
	public List<Article> findIndexArticle(); //首页文章
	public List<Scenic> findIndexScenic(); //首页风景图片
	public List<Food> findIndexFood(); //首页美食图片
}
