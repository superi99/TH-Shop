package com.digitalnews.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digitalnews.dao.ArticleDao;

@WebServlet(urlPatterns = "/trang-chu")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArticleDao dao = new ArticleDao();
			request.setAttribute("article", dao.getNewest());
			request.getRequestDispatcher("views/Home.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("error", "sorry something wrong happen");
			request.getRequestDispatcher("views/error.jsp").forward(request, response);
		}
		
	}



}
