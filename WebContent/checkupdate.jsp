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
    
    <title>查寝信息更新</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="main.css">
	<script type="text/javascript">
	function check(){
		var dat=document.getElementById("dat").value;
		if(dat==""){
		alert("日期不能为空！");
		return false;
		}
		var sno=document.getElementById("sno").value;
		if(sno==""){
		alert("学号不能为空！");
		return false;
		}
	var name=document.getElementById("name").value;
	if(name==""){
	alert("姓名不能为空！");
	return false;
	}
	var tno=document.getElementById("tno").value;
	if(tno==""){
	alert("楼栋号不能为空！");
	return false;
	}
	var dno=document.getElementById("dno").value;
	if(dno==""){
	alert("宿舍号不能为空！");
	return false;
	}
	}
	</script>
	<%
  		/*
  		 * 初始化一个search对象
  		 */ 
  		Search user = new Search();
	//dat
		String dat = request.getParameter("dat");  	
  	dat = dat==null?null:new String(dat);
		user.setDat(dat);  
  	 //sno
		String sno = request.getParameter("sno"); 	
		sno = sno==null?null:new String(sno);
		user.setSno(sno);
  		//name
  		String name = request.getParameter("name"); 	
  		name = name==null?null:new String(name);
  		user.setName(name);
  		// System.out.println(name);
	  	//tno
  		String tno = request.getParameter("tno"); 	
  		tno = tno==null?null:new String(tno);
  		user.setTno(tno);
  		// System.out.println(tno);
  		//dno
  		String dno = request.getParameter("dno"); 
  		dno = dno==null?null:new String(dno);
  		user.setDno(dno);
  
       /**
       *执行update操作 
       */
       String update=request.getParameter("update");
       if(update!=null){
        		 if(SearchOperation.update(user)){
        	          out.println("<script type=\"text/javascript\">");
        	          out.println("alert(\"修改成功！\");");
        	          out.println("open(\"check.jsp\",\"_self\");");
        	          out.println("</script>");
        	        }
        	        else{
        	          out.println("<script type=\"text/javascript\">");
        			  out.println("alert(\"修改失败！自动返回！\");");
        			  out.println("open(\"check.jsp\",\"_self\");");
        			  out.println("</script>");
        			  
        		
        	}
        }
        /**
       * 如果action是delete则是删除操作
       */
        String action =request.getParameter("action");
       if(action!=null){
            if(action.equals("delete")){
                if(SearchOperation.delete(user)){
                 out.println("<script type=\"text/javascript\">");
        	          out.println("alert(\"删除成功！\");");
        	          out.println("open(\"check.jsp\",\"_self\");");
        	          out.println("</script>");
                }   
                else {
                      out.println("<script type=\"text/javascript\">");
        	          out.println("alert(\"删除失败！\");");
        	          out.println("open(\"check.jsp\",\"_self\");");
        	          out.println("</script>");
                }         
            }   
            return;   
        }
           /*
		  *设置action隐藏控件的值
		  */
			pageContext.setAttribute("update",action);
			pageContext.setAttribute("dat",dat);
			  pageContext.setAttribute("sno",sno);
			  pageContext.setAttribute("name",name);
			  pageContext.setAttribute("tno",tno);
			  pageContext.setAttribute("dno",dno);
		  
%>

  </head>
  
  <body>
    <div id="update">
		    <form action="checkupdate.jsp"     id="updateform" style="position:relative;">
		    <img  src="./images/update.png" style="width:100%;height:100%;position:absolute;">
		   
		  <table id="updatetable">
		  <tr>
		  <td><input type="hidden" name="update" value="1"></td>
		  	  
		  </tr>
		 <tr>
			  <td>查寝日期:</td>
			  <td><input id="dat" type="text" name="dat" value="${pageScope.dat}"></td>
			  </tr>
			  <tr>
			  <td>学生学号:</td>
			  <td><input id="sno" type="text" name="sno" value="${pageScope.sno}"></td>
			  </tr>
			   <tr>
			  <td>学生姓名:</td>
			  <td><input id="name" type="text" name="name" value="${pageScope.name}"></td>
			  </tr>
			   <tr>
			  <td>楼栋号:</td>
			  <td><input id="tno" type="text" name="tno" value="${pageScope.tno}"></td>
			  </tr>
			   <tr>
			  <td>宿舍号:</td>
			  <td><input  id="dno" type="text" name="dno" value="${pageScope.dno}"></td>
			  </tr>
			   </tr>
					  <tr>
			  <td align="center"><input type="submit" value="提交"  style="width:80px;height:35px;border-radius:5px;line-height:35px;" ></td>
			  </tr>
		  </table>
		  
		  </form>
		   
  
  
		  </div>
  </body>
</html>
