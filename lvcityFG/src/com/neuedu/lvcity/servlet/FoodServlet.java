package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.Request;
import com.neuedu.lvcity.model.Admin;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Contact;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.FoodType;
import com.neuedu.lvcity.service.AdminService;
import com.neuedu.lvcity.service.ArticleService;
import com.neuedu.lvcity.service.ContactService;
import com.neuedu.lvcity.service.FoodService;
import com.neuedu.lvcity.service.FoodTypeService;
import com.neuedu.lvcity.service.impl.AdminServiceImpl;
import com.neuedu.lvcity.service.impl.ArticleServiceImpl;
import com.neuedu.lvcity.service.impl.ContactServiceImpl;
import com.neuedu.lvcity.service.impl.FoodServiceImpl;
import com.neuedu.lvcity.service.impl.FoodTypeServiceImpl;


/**
 * Servlet implementation class FoodServlet
 */
//@WebServlet("/User/Food")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServlet() {
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
		//防止取中文参数出现乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		
	    //显示左边所有美食分类
		if("show".equals(action)){
			doShow(request,response);
     	//显示对应分类下面的各种美食列表
		}else if("showList".equals(action)){
			doShowList(request,response);
			//查看某种食物的详细信息，包括发布人等
		}else if("watch".equals(action)){
			doWatch(request,response);
		}
		//模糊查询
		else if("search".equals(action)){
			doSearch(request,response);
		}
	}
    
	/**
	 * 模糊查询某分类下的美食
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String like = request.getParameter("like");
		int ftid =Integer.parseInt(request.getParameter("ftid"));
		int pageNow =Integer.parseInt( request.getParameter("pageNow"));
		
		if(like.trim().equals("null")) {
			doShowList(request, response);
		}else {
			cx(like, ftid, pageNow,request,response);
		}
		
	}
	
	/**
	 * 查询某分类下满足模糊查询的食物
	 * @param like
	 * @param ftid
	 * @param pageNow
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void cx(String like, int ftid, int pageNow,HttpServletRequest request, HttpServletResponse response) throws IOException {
		   //获取session
        HttpSession se = request.getSession();
        //将“暂无记录”标志先设置清空
        se.setAttribute("zwjl", null);
        
		// 获取美食service层实例
		FoodService  foodService =FoodServiceImpl.getInstance();
		// 获取美食分类service层实例
		FoodTypeService  foodTypeService =FoodTypeServiceImpl.getInstance();
		
		int pageSize = 9;//一页9条数据
		int rowCount = foodService.getCountByLike("%"+like+"%", ftid);//该类型一共有几条数据
		/*System.out.println("%"+like+"%");
		System.out.println(ftid);*/
		if(rowCount == 0) {
			se.setAttribute("zwjl", "1");
		}
		int pageCount;//一共有多少页
		if(rowCount % pageSize == 0){
		    pageCount = rowCount/pageSize;
		}else{
		    pageCount = rowCount/pageSize + 1;
		}
		
		if(pageNow<1){
			pageNow=1;
		}
		if(pageNow>pageCount){
			pageNow=pageCount;
		}
		
		int start=0;
		if(pageNow==1){
			start=0;
		}else if (pageNow==0) {
			start=(pageNow)*pageSize;
			pageNow = 1;
			pageCount= 1;
		}else{
			start=(pageNow-1)*pageSize;
		}
		
		
		se.setAttribute("pageNow",pageNow);
		se.setAttribute("rowCount",rowCount);
		se.setAttribute("pageCount",pageCount);
		se.setAttribute("pageSize",pageSize);
		se.setAttribute("ftid",ftid);
		se.setAttribute("like","null");
		String foodtype = foodTypeService.gettypebyid(ftid);
		se.setAttribute("foodtype",foodtype);
		
		List<Food> foodlist = foodService.foodListByLike("%"+like+"%", ftid, start);		
		se.setAttribute("foodlist",foodlist);		
		//System.out.println(foodlist.size());
		
		 response.sendRedirect(request.getContextPath()
					+ "/User/foodList.jsp");
		
	}

	private void doWatch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  //获取session
        HttpSession se = request.getSession();
        
        int pageNow = Integer.parseInt(request.getParameter("pageNow"));
        int ftid = Integer.parseInt(request.getParameter("ftid"));
        int aid = Integer.parseInt(request.getParameter("aid"));
        
        //获取service
        ArticleService articleService = ArticleServiceImpl.getInstance();
        AdminService adminService = AdminServiceImpl.getInstance();
        
		Article article = articleService.getArticleById(aid);
		Admin admin = adminService.getAdminById(article.getPublisher());
		
		se.setAttribute("article",article);
		se.setAttribute("admin",admin);
		se.setAttribute("pageNow",pageNow);
		se.setAttribute("ftid",ftid);
		

		 response.sendRedirect(request.getContextPath()
					+ "/User/foodDetail.jsp");
		
	}
   
	/**
	 * 查询某分类下的美食
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void doShowList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		   //获取session
        HttpSession se = request.getSession();
        //将“暂无记录”标志先设置清空
        se.setAttribute("zwjl", null);
		
		// 获取美食service层实例
		FoodService  foodService =FoodServiceImpl.getInstance();
		// 获取美食分类service层实例
		FoodTypeService  foodTypeService =FoodTypeServiceImpl.getInstance();
		
		//获取从JSP页面传递过来的pageNow当前页参数
		int pageNow = Integer.parseInt(request.getParameter("pageNow"));
		//获取从JSP页面传递过来的选择的当前美食分类
		int ftid = Integer.parseInt(request.getParameter("ftid"));

		int pageSize = 9;//一页9条数据
		int rowCount = foodService.getCountByFtid(ftid);//该类型一共有几条数据
		if(rowCount == 0) {
			//设置“暂无记录”标准
			se.setAttribute("zwjl", "1");
		}
		int pageCount;//一共有多少页
		if(rowCount % pageSize == 0){
		    pageCount = rowCount/pageSize;
		}else{
		    pageCount = rowCount/pageSize + 1;
		}
		
		//不足一页，默认显示第一页
		if(pageNow<1){
			pageNow=1;
		}
     //当前页超过最大页，设置当前页为最大页
		if(pageNow>pageCount){
			pageNow=pageCount;
		}
		
		int start=0;
		if(pageNow==1){
			//如果是第一页，从0开始
			start=0;
		}else if (pageNow==0) {
			start=(pageNow)*pageSize;
			pageNow = 1;
			pageCount= 1;
		}else{
			start=(pageNow-1)*pageSize;
		}
		
		se.setAttribute("pageNow",pageNow);
		se.setAttribute("rowCount",rowCount);
		se.setAttribute("pageCount",pageCount);
		se.setAttribute("pageSize",pageSize);
		se.setAttribute("ftid",ftid);
		se.setAttribute("like","null");
		String foodtype = foodTypeService.gettypebyid(ftid);
		se.setAttribute("foodtype",foodtype);
		
		List<Food> foodlist = foodService.foodListByFtid(ftid, start);
		se.setAttribute("foodlist",foodlist);
		
		 response.sendRedirect(request.getContextPath()
					+ "/User/foodList.jsp");
		
	}

	private void doShow(HttpServletRequest request, HttpServletResponse response) throws IOException {
		   //获取session
        HttpSession se = request.getSession();
		
		// 调用Service方法
		FoodTypeService  foodTypeService =FoodTypeServiceImpl.getInstance();
		ContactService contactService = ContactServiceImpl.getInstance();
		
		// TODO Auto-generated method stub
		List<FoodType> foodtypelist = foodTypeService.findFoodtype();
		se.setAttribute("foodtypelist",foodtypelist);
		
		int firstfoodtypeid = foodtypelist.get(0).getFtid();
		se.setAttribute("firstfoodtypeid",firstfoodtypeid);
		
		//联系方式处
		Contact contact = contactService.findContact();
		se.setAttribute("contact",contact);

		 response.sendRedirect(request.getContextPath()
					+ "/User/foodIndex.jsp");
		
	}

}
