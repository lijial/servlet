package com.jalo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求的url : http://localhost:8080/HttpServlet
 * 只有当请求这个url时候，如下四个打印语句才会打印
 */
public class HttpServlet extends javax.servlet.http.HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("===========init without parameters===========");
		super.init();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("===========init with parameters===========");
		super.init(config);
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req,resp);
		System.out.println("===========service===========");
		PrintWriter pw = resp.getWriter();//以字符为单位
		pw.write("servlet send Hello world."); //用于向客户端浏览器输出helloworld字符�?
		pw.close();

	}

	//这个doget方法不能并行，是串行
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		System.out.println("===========doget===========" + Thread.currentThread().getName()+","+new Date());
		PrintWriter pw = resp.getWriter();//以字符为单位
		pw.write("doget()"+Thread.currentThread().getName()+","+new Date()+"\r");
		pw.write("servlet param is " + this.getInitParameter("servletParam")
				+", servletContext param is " + getServletContext().getInitParameter("contextParam"));
		pw.close();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void destroy() {
		System.out.println("===========destroy===========");
		super.destroy();
	}


}
 