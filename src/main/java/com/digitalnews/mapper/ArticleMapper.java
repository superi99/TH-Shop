package com.digitalnews.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.digitalnews.model.Article;

public class ArticleMapper implements IRowMapper<Article> {

	@Override
	public Article mapRow(ResultSet rs) {
		try {
			Article art = new Article();
			art.setId(rs.getInt("id"));
			art.setTitle(rs.getString("title"));
			art.setImage(rs.getString("image"));
			art.setContent(rs.getString("content"));
			art.setDate(rs.getDate("date"));
			art.setAuthor(rs.getString("author"));
			art.setShortContent(rs.getString("short_content"));
			return art;
		} catch (SQLException e) {
			return null;
		}

	}


}
