package com.jalo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServlet extends javax.servlet.http.HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("=========init without parameters===========");
		super.init();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("=========init with parameters===========");
		super.init(config);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("=========service===========");
		PrintWriter pw = resp.getWriter();//以字符为单位
		pw.write("servlet send Hello world."); //用于向客户端浏览器输出helloworld字符�?
		pw.close();
	}

	@Override
	public void destroy() {
		System.out.println("=========destroy===========");
		super.destroy();
	}


}
 