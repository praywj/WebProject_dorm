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
@WebServlet("/Login.do")  //����һ��servlet ���ҷ�����Ϊ 
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�ύ��ʽΪGetʱִ���������
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�ύ��ʽΪPostʱִ���������
		//��ʼ���Ĳ��������ñ����
		//request: ����������󣬿ͻ����͵����������ύ������
		//response:������Ӧ���󣬷���������֮�󽫽��(html)���ظ��ͻ���
		request.setCharacterEncoding("utf-8");  //�����������
		response.setCharacterEncoding("utf-8"); //������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();  //�õ������
		//Ҫִ�еĴ���д����:�����û�������
		//��ȡ�û����͹�������������
		String name=request.getParameter("loginname");
		String pwd=request.getParameter("loginpass");
		System.out.println("�û��ύ������Ϊ:"+name+","+pwd);
		if(name.equals("admin")&& pwd.equals("admin")){
			out.println("<script>alert('��¼�ɹ�!')</script>");
			response.setHeader("refresh", "0;url=index.jsp");
		}else if(name==null||name==""){
			out.println("<script>alert('�û�������Ϊ�գ��������û���!')</script>");
			response.setHeader("refresh", "0;url=login.jsp");
		}else if(pwd==null||pwd==""){
			out.println("<script>alert('���벻��Ϊ�գ�����������!')</script>");
			response.setHeader("refresh", "0;url=login.jsp");
		}else{
			out.println("<script>alert('��¼ʧ�ܣ�3��󷵻�!')</script>");
			response.setHeader("refresh", "1;url=login.jsp");
		}
		out.flush();
		out.close();
	}

}
