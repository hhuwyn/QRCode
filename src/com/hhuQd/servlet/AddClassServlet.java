package com.hhuQd.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hhuQd.entity.Classes;
import com.hhuQd.service.ClassService;

public class AddClassServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddClassServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置请求和响应的编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 获取到要保存谁
		String select_xy = request.getParameter("select_xy");
		String select_zy = request.getParameter("select_zy");
		String select_nj = request.getParameter("select_nj");
		String select_bj = request.getParameter("select_bj");
		// 需要调用servlet进行业务逻辑的处理

		Classes d = new Classes();
		d.setCclassno(select_bj);
		d.setCgrade(select_nj);
		d.setCdepartment(select_xy);
		d.setCprofession(select_zy);
     
		ClassService ds = new ClassService();
		try {
			ds.saveDictionary(d);
			request.setAttribute("msg", "添加数据成功");

		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());

		}
		
		//调用 字典业务逻辑类 中查询的方法
 		java.util.List<Classes> list= ds.queryAll();
		//并且将查询的结果存放在某一个范围中
		request.setAttribute("data", list);
		request.setAttribute("flag", 3);  
		
		//返回结果
		// 此处的/就表示应用程序的根目录 http://localhost:8080/e/
		request.getRequestDispatcher("/Manager_Main.jsp").forward(request, response);

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
