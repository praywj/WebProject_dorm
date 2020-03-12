package com.newer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlets
 */
@WebServlet("/Login.do")  //生成一个servlet 并且访问名为 
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//提交方式为Get时执行这个方法
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//提交方式为Post时执行这个方法
		//初始化的操作：设置编码等
		//request: 代表请求对象，客户发送的所有请求，提交的数据
		//response:代表响应对象，服务器处理之后将结果(html)返回给客户端
		request.setCharacterEncoding("utf-8");  //设置请求编码
		response.setCharacterEncoding("utf-8"); //设置响应编码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();  //得到输出流
		//要执行的代码写这里:处理用户的请求
		//获取用户发送过来的请求数据
		String name=request.getParameter("loginname");
		String pwd=request.getParameter("loginpass");
		System.out.println("用户提交的数据为:"+name+","+pwd);
		if(name.equals("admin")&& pwd.equals("admin")){
			out.println("<script>alert('登录成功!')</script>");
			response.setHeader("refresh", "0;url=index.jsp");
		}else if(name==null||name==""){
			out.println("<script>alert('用户名不能为空，请输入用户名!')</script>");
			response.setHeader("refresh", "0;url=login.jsp");
		}else if(pwd==null||pwd==""){
			out.println("<script>alert('密码不能为空，请输入密码!')</script>");
			response.setHeader("refresh", "0;url=login.jsp");
		}else{
			out.println("<script>alert('登录失败，3秒后返回!')</script>");
			response.setHeader("refresh", "1;url=login.jsp");
		}
		out.flush();
		out.close();
	}

}
