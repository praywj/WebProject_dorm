<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	 <title>宿舍管理系统</title>
	<style type="text/css">
		@keyframes fade-in{  
		    0%{ opacity: 0;}
		    100%{opacity:1;}
		}
		@-webkit-keyframes fade-in{
		    0%{ opacity: 0;}
		    100%{opacity:1;}
		}
		@-ms-keyframes fade-in{
		    0%{ opacity: 0;}
		    100%{opacity:1;}
		}
		@-o-keyframes fade-in{
		    0%{ opacity: 0;}
		    100%{opacity:1;}
		}
		@-moz-keyframes fade-in{
		    0%{ opacity: 0;}
		    100%{opacity:1;}
		}
		
		em{ 
			color:black;
			font:55px/70px  "楷体";
		    opacity: 0;      /*实先规定文字的状态是不显示的*/
		    animation: fade-in 4s ease 0s 1;    /*调用名称为fade-in的动画，全程动画显示时间4S，进入方式为ease，延时0S进入，播放次数1次*/
		    -webkit-animation: fade-in 4s ease 0s 1;
		    -moz-animation: fade-in 4s ease 0s 1;
		    -o-animation: fade-in 4s ease 0s 1;
		    -ms-animation: fade-in 4s ease 0s 1;
		    
		    /*规定动画的最后状态为结束状态*/
		    animation-fill-mode:forwards;
		    -webkit-animation-fill-mode: forwards;  
		      -o-animation-fill-mode: forwards; 
		      -ms-animation-fill-mode: forwards;   
		      -moz-animation-fill-mode: forwards; 
		}
		body{margin: 0;padding: 0;width: 100%;height: 650px;}
		#tit{width:550px;margin: 0 auto;text-align: center;font-size: 40px;height: 60px;padding-top: 200px;color: white;}
			</style>
			 <script language="javascript" type="text/javascript"> 
			
			// 以下方式定时跳转
			setTimeout("javascript:location.href='login.jsp'", 5000); 
			</script> 
  </head>
  

<body>
	 <img src="images/8.jpg"  style="width:100%;height:650px;position:absolute;z-index:-200;">
	<div id="tit">
		<em >欢迎使用宿舍管理系统</em>
	</div>
</body>

</html>
