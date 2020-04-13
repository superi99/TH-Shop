package com.digitalnews.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digitalnews.dao.ArticleDao;
import com.digitalnews.model.Article;
import com.digitalnews.model.ParentModel;

@WebServlet("/tim-kiem")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchController() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			ArticleDao artDao = new ArticleDao();
			ParentModel<Article> art = new Article();
			String textSearch = request.getParameter("textSearch");
			if ("".equalsIgnoreCase(textSearch)) {
				request.setAttribute("error", "nhập data vào ô search bạn ơi. táy máy tò mò ko tốt đâu nha!");
			} else {
				String page = request.getParameter("page");
				String maxPageItem = request.getParameter("maxPageItem");
				 
				if (maxPageItem != null	&& maxPageItem.matches("[0-9]+")) {
					art.setMaxPageItem(Integer.parseInt(maxPageItem));
				} else {
					art.setMaxPageItem(2);
				}

				if (page != null && page.matches("[0-9]+")) {
					art.setPage(Integer.parseInt(page));
				} else {
					art.setPage(1);
				}

				art.setTextSearch(textSearch);
				int startItem = (art.getPage() - 1) * art.getMaxPageItem() + 1;
				art.setListResult(artDao.searchByTitle(textSearch, startItem, art.getPage() * art.getMaxPageItem()));
				art.setTotalItem(artDao.getTotalItemSearch(textSearch));
				art.setTotalPage((int) Math.ceil((double) art.getTotalItem() / art.getMaxPageItem()));

				if(art.getTotalItem() > 0) {
					request.setAttribute("model", art);
				}else {
					request.setAttribute("error", "not found");
				}
				
			}

			request.getRequestDispatcher("views/Search.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", "sorry something wrong happen");
			request.getRequestDispatcher("views/error.jsp").forward(request, response);
		}

	}

}
