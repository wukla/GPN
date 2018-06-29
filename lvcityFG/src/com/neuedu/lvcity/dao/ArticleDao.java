package com.neuedu.lvcity.dao;

import java.util.List;

import com.neuedu.lvcity.model.Article;

public interface ArticleDao {
   public Article getArticleById(int aid);
	
	public List<Article> findHistoricArticle(); //查询历史类文章
	
	public int findHistorcCount(); //查询历史类文章数
}
