<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="main.css">

  </head>
  
  <body style="background:url(images/login.png)">
    <form action="login.jsp" method="post" id="form">
    		<div id="filter"></div>
    		<h1 align="center" id="logintitle">用户注册</h1>
    		<table id="logintable" >
 
    			<tr >
    				<th>账号:</th>
    				<td ><input type="text" name="regname" id="loginname"></td>
    			</tr>
    			<tr >
    				<th>密码:</th>
    				<td ><input type="password" name="regpass" id="loginname"></td>
    			</tr>
    			
    			<tr>
    				<td colspan="2" align="center"><input type="submit" value="注册" id="loginname">
    				<input type="reset" value="重置"  id="loginname">
    				</td>
    			</tr>
    		</table>
    		
    	</form>
  </body>
</html>
