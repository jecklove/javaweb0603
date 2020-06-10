package org.jgs1905.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	测试生命周期
 * @author junki
 * @date 2020年6月3日
 */
@WebServlet(value = "/life", initParams = {
		@WebInitParam(name = "app_name", value = "jgs1905app"),
		@WebInitParam(name = "release_date", value = "2020-06-03")
})
public class LifeController extends HttpServlet {

	private static final long serialVersionUID = -3926398569075912177L;

	// 第一次请求执行一次
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("我被初始化了");
		String appName = config.getInitParameter("app_name");
		String releaseDate = config.getInitParameter("release_date");
		System.out.println("appName = " + appName);
		System.out.println("releaseDate = " + releaseDate);
	}
	
	// 每一次请求都要执行
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("我执行了服务");
	}

	// 当服务器正常关闭时执行一次
	@Override
	public void destroy() {
		System.out.println("我销毁了");
	}

	
	
}
