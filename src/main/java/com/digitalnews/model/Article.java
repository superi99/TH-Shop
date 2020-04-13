package com.digitalnews.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Article extends ParentModel<Article> {

	private int id;
	private String title;
	private String image;
	private String content;
	private String shortContent;

	public String getShortContent() {
		return shortContent;
	}

	public void setShortContent(String shortContent) {
		this.shortContent = shortContent;
	}

	private Date date;
	private String author;

	public Article() {
		// TODO Auto-generated constructor stub
	}

	public Article(int id, String title, String image, String content, Date date, String author) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.content = content;
		this.date = date;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() throws NamingException {
		Context ct = (Context) new InitialContext().lookup("java:/comp/env");
		String url = (String) ct.lookup("imgLink");
		return url + this.image;

	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		String dateFormat = new SimpleDateFormat("MMM dd yyyy - hh:mma").format(this.date);
		int length = dateFormat.length();
		return dateFormat.substring(0, length - 2) + dateFormat.substring(length - 2, length).toLowerCase();

	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
