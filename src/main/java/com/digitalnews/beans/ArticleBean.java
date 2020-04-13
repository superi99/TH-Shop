package com.digitalnews.beans;

import java.util.List;

import com.digitalnews.dao.ArticleDao;
import com.digitalnews.model.Article;

public class ArticleBean {
	public Article getNewest() {
		try {
			return new ArticleDao().getNewest();
		} catch (Exception e) {
			return null;
		}

	}
	
	public List<Article> getArticles(){
		try {
			return new ArticleDao().getArticles();
		} catch (Exception e) {
			return null;
		}
	}
}
