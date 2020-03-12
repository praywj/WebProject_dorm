<%@page import="com.db.DBUtils"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.db.DBOperation"%>
<%@page import="com.entity.Search"%>
<%@page import="com.db.SearchOperation"%>
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
     <%
		Connection con=DBUtils.getConn();
	   String sql="select * from search";
	   PreparedStatement pst= con.prepareStatement(sql);
	   ResultSet rs=pst.executeQuery();
      %>
  </head>
  
  <body>
    <div id="bodys" class="bodys">
	<div id="bodys-bg" class="bodys-bg">
          <div id="bodys-1" >
	           <div id="bodys-left" class="bodys-left">
		      <div id="bodys-left-list" class="bodys-left-list">
			<ul class="bodys-nav">
				<li><a href="index.jsp"><h2><img src="./images/new.png">&nbsp&nbsp&nbsp首页</h2></a></li>
				
				<li><a href="student.jsp"><h2><img src="./images/new.png">&nbsp&nbsp&nbsp学生管理</h2></a></li>
				<li><a href="storey.jsp"><h2><img src="./images/new.png">&nbsp&nbsp&nbsp楼栋管理</h2></a></li>
				<li><a href="dorm.jsp"><h2><img src="./images/new.png">&nbsp&nbsp&nbsp宿舍管理</h2></a></li>
				<li id="hov" class="hov"><a href="check.jsp"><h2  id="hov" class="hov"><img src="./images/new.png">&nbsp&nbsp&nbsp查寝管理</h2></a></li>
				
			</ul>
		      </div>
		 </div> 
	    <div id="bodys-left-border" class="bodys-left-border"></div>
	     <div id="bodys-right" class="bodys-right">
		<div id="bodys-right-list" class="bodys-right-list">
			<ul>
				<li><h1  align="center" style="color:#4a68ab;font-size:22px;">查寝管理</h1></li>
			</ul>
			<table border="1px" id="maintable">
			<tr>
				<th width="13%">学号</th>
				<th width="13%">姓名</th>
				<th width="13%">楼栋号</th>
				<th width="13%">宿舍号</th>
				<th width="20%">缺寝日期</th>
				<th width="25%">操作</th>
			</tr>
				<%  
            	while (rs.next()) {  
       			 %>  
          <tr>
            <td style="text-align:center;">  
                <%  
                    out.print(rs.getString(2));  
                %>  
            </td >  
            <td style="text-align:center;">  
                <%  
                	 out.print(rs.getString(3));   
                %>  
            </td >  
            <td style="text-align:center;">  
                <%  
                    out.print(rs.getString(4));  
                %>  
            </td>  
            <td style="text-align:center;">  
                <%  
                    out.print(rs.getString(5));  
                %>  
            </td>
            <td style="text-align:center;">  
                <%  
                    out.print(rs.getString(1));  
                %>  
            </td>
            
             <td style="text-align:center;">
          <a href="checkupdate.jsp?sno=<%=rs.getString(2) %>&&name=<%=rs.getString(3) %>&&tno=<%=rs.getString(4) %>&&dno=<%=rs.getString(5) %>&&dat=<%=rs.getString(1) %>" >修改</a>
          <a href="checkupdate.jsp?action=delete&&sno=<%=rs.getString(2) %>&&name=<%=rs.getString(3) %>&&tno=<%=rs.getString(4) %>&&dno=<%=rs.getString(5) %>&&dat=<%=rs.getString(1) %>" >删除</a>
          </td>  
        </tr>  
        <%  
            }  
        %>  
      
			</table>
		</div>
          			<a href="checkinsert.jsp"><input type="button" value="添加" style="width:100px;height:35px;padding:5px;border-radius:5px;"></a>
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
