package com.neuedu.lvcity.service;

import java.util.List;

import com.neuedu.lvcity.model.Article;

public interface ArticleService {
	  public Article getArticleById(int aid);
		
		public List<Article> findHistoricArticle(); //查询历史类文章
		
		public int findHistorcCount(); //查询历史类文章数
}
