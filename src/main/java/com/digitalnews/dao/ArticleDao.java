package com.digitalnews.dao;

import java.util.ArrayList;
import java.util.List;

import com.digitalnews.mapper.ArticleMapper;
import com.digitalnews.model.Article;

public class ArticleDao extends ParentDao<Article> {

	public Article getNewest() throws Exception {

		String sql = "select * from article order by date desc limit 1 ;";
		List<Article> arts = query(sql, new ArticleMapper());
		return arts.isEmpty() ? null : arts.get(0);

	}

	public List<Article> getArticles() throws Exception {
			String sql = "select * from article limit 5;";
			return query(sql, new ArticleMapper());
		
	}

	public List<Article> searchByTitle(String textSearch, int u, int v) throws Exception {

		String sql = "select a.* from (select *, row_number() Over(order by article.id) as `row` from article where title like ? ) as a "
				+ "where a.row >= ? and a.row <= ?;";
//		String sql = "select * from article where title like ?";
		return query(sql, new ArticleMapper(), "%" + textSearch + "%", u, v);

	}

	public int getTotalItemSearch(String textSearch) throws Exception {

		String sql = "select count(*) from article where title like ?";
		return count(sql, "%" + textSearch + "%");

	}

	public Article artDetail(int id) throws Exception {

		List<Article> arts = new ArrayList<>();
		String sql = "select * from article where id = ?";
		arts = query(sql, new ArticleMapper(), id);
		return arts.isEmpty() ? null : arts.get(0);

	}

}
