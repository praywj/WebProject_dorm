package com.newer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/Reg.do")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");  //�����������
		response.setCharacterEncoding("utf-8"); //������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();  //�õ������
		String name=request.getParameter("regname");
		String pwd=request.getParameter("regpass");
		String sex=request.getParameter("regsex");
		String msg="�û����������Ϊ:";
		msg+= "  ����:"+name +"  ����:" +pwd + "  �Ա�:" + sex;
		out.println(msg);
		//session �Ự
		out.flush();
		out.close();
	}

}
