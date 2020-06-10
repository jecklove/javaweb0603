package org.jgs1905.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author junki
 * @date 2020年6月3日
 */
public class HelloController extends HttpServlet {

	private static final long serialVersionUID = -7879749002970608725L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println(config.getInitParameter("app_name"));
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 控制台打印
		System.out.println("hello servlet");
		
		// 解决响应乱码
		response.setContentType("text/html; charset=UTF-8");
		
		// 向页面返回数据
		PrintWriter writer = response.getWriter();
		writer.print("<h1>hello servlet</h1>");
		writer.print("<h1>你好世界</h1>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 如果接收的是post请求，转而让doGet方法来处理业务
		doGet(req, resp);
	}

}
