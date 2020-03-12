<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>校园宿舍管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="main.css">
	<script src="jquery.js" type="text/javascript"></script>
	<script src="7.js" type="text/javascript"></script>

  </head>
  
  <body>
  <div class="head">
            <div class="logo fl"><a href="#"></a></div>
            <h3 class="head_text ">校园宿舍后台管理系统</h3>
    </div>
  <div class="operation_user clearfix">
    	<div class="link fr">
            <b>欢迎您        &nbsp; <span style="color:red;">admin</span>
            </b>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="#" class="icon icon_i">首页</a><span></span>
            <a href="#" class="icon icon_j">前进</a><span></span>
            <a href="#" class="icon icon_t">后退</a><span></span>
            <a href="index.jsp" class="icon icon_n">刷新</a><span></span>
            <a href="login.jsp" class="icon icon_e">退出</a>
        </div>
      </div>
    <div id="bodys" class="bodys">
   
	<div id="bodys-bg" class="bodys-bg">
          <div id="bodys-1" >
	           <div id="bodys-left" class="bodys-left">
		          	
		      <div id="bodys-left-list" class="bodys-left-list">
			<ul class="bodys-nav">
				<li id="hov" class="hov"><a href="index.jsp"><h2  id="hov" class="hov"><img src="./images/new.png">&nbsp&nbsp&nbsp首页</h2></a></li>
				
				<li><a href="student.jsp"><h2><img src="./images/new.png">&nbsp&nbsp&nbsp学生管理</h2></a></li>
				<li><a href="storey.jsp"><h2><img src="./images/new.png">&nbsp&nbsp&nbsp楼栋管理</h2></a></li>
				<li><a href="dorm.jsp"><h2><img src="./images/new.png">&nbsp&nbsp&nbsp宿舍管理</h2></a></li>
				<li><a href="check.jsp"><h2><img src="./images/new.png">&nbsp&nbsp&nbsp查寝管理</h2></a></li>
				
			</ul>
		      </div>
		 </div> 
	    <div id="bodys-left-border" class="bodys-left-border"></div>
	     <div id="bodys-right" class="bodys-right">
		
		<div id="bodys-right-list" class="bodys-right-list">
			<ul>
				<li><h1  align="center" style="color:#4a68ab;font-size:22px;">首页</h1></li>
					
			</ul>
		<center style="margin-top:60px;">
					<h3>系统信息</h3>
				<table width="70%" border="1" cellpadding="5" cellspacing="0" bgcolor="#cccccc" id="indextable">
					<tr>
						<th>运行环境</th>
						<td> Windows XP</td>
					</tr>
					<tr>
						<th>Myeclipse版本</th>
						<td>Myeclipse 10</td>
					</tr>
					<tr>
						<th>Tomcat版本</th>
						<td>Tmocat 7.0</td>
					</tr>
					<tr>
						<th>开发模式</th>
						<td>团队开发模式</td>
					</tr>
				</table>
				<h3 style="margin-top:20px;">软件信息</h3>
				<table width="70%" border="1" cellpadding="5" cellspacing="0" bgcolor="#cccccc" id="indextable">
					<tr>
						<th>系统名称</th>
						<td>校园信息管理系统</td>
					</tr>
					<tr>
						<th>开发团队</th>
						<td>长理计通计科1404</td>
					</tr>
					
					<tr>
						<th>成功案例</th>
						<td>校园信息管理系统</td>
					</tr>
				</table>
			</center>
		</div>
          </div>
	</div>
</div>
</div>
 
      <div id="footer-2">
  <div style="width:1500px;">
                 <div id="footer-3">
                   
                 </div>
                  <p>Copyright&nbsp;&nbsp;2016&nbsp;X689.COM</br>长沙理工大学计通学院&nbsp;版权所有&nbsp;Power&nbsp;by&nbsp;DedeCsm</br>联系电话：400-999-0750&nbsp;传真：&nbsp;邮箱：</br>ICP备案编号：粤ICP备66993101号&nbsp;-1</p>       
        </div></div>
  </body>
</html>
