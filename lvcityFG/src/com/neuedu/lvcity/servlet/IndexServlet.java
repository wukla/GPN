package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.Scenic;
import com.neuedu.lvcity.service.IndexService;
import com.neuedu.lvcity.service.impl.IndexServiceImpl;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		   //获取session
        HttpSession se = request.getSession();
		
		// 调用Service方法
		IndexService indexService = IndexServiceImpl.getInstance();
		
		List<Banar> banarList = indexService.findBanar();
		se.setAttribute("banarList", banarList);
		List<Article> articleList = indexService.findIndexArticle();
		se.setAttribute("articleList", articleList);
		List<Scenic> scenicList = indexService.findIndexScenic();
		se.setAttribute("scenicList", scenicList);
		List<Food> foodList = indexService.findIndexFood();
		se.setAttribute("foodList", foodList);
		 response.sendRedirect(request.getContextPath()
					+ "/User/index.jsp");
	}

}
