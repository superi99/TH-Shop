package com.digitalnews.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.digitalnews.dao.ArticleDao;
import com.digitalnews.model.Article;

@WebServlet("/chi-tiet")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DetailController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {// chưa bắt lỗi
				// đã bắt

			String idStr = request.getParameter("id");

			if (idStr.matches("[0-9]+")) {
				Integer id = Integer.parseInt(idStr);

				Article art = new ArticleDao().artDetail(id);

				if (art != null) {
					request.setAttribute("article", art);
				} else {
					request.setAttribute("error", "không tìm thấy bài báo");
				}
			} else {
				request.setAttribute("error", "id phải là số");
			}

			request.getRequestDispatcher("views/Home.jsp").forward(request, response);

		} catch (Exception e) {
			//request.setAttribute("error", e.getMessage());
			request.setAttribute("error", "ko cho ng dùng xem lỗi thì throw ra controller làm gì :(");
			request.getRequestDispatcher("views/error.jsp").forward(request, response);
		}
	}

}
