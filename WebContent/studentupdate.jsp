<%@page import="com.db.StuOperation"%>
<%@page import="com.entity.Stu"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加学生信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="main.css">
	<script type="text/javascript">
	function check(){
		var sno=document.getElementById("sno").value;
		if(sno==""){
		alert("学号不能为空！");
		return false;
		}
	var sex=document.getElementById("sex").value;
	if(sex==""){
	alert("性别不能为空！");
	return false;
	}
	var name=document.getElementById("name").value;
	if(name==""){
	alert("姓名不能为空！");
	return false;
	}
	var dno=document.getElementById("dno").value;
	if(dno==""){
	alert("宿舍号不能为空！");
	return false;
	}
	var tno=document.getElementById("tno").value;
	if(tno==""){
	alert("楼栋号不能为空！");
	return false;
	}
	var tel=document.getElementById("tel").value;
	if(tel==""){
	alert("电话号码不能为空！");
	return false;
	}
	
	}
	</script>
	<%
  		/*
  		 * 初始化一个Stu对象
  		 */ 
  		Stu user = new Stu();
	//sno
		String sno = request.getParameter("sno"); 	
		sno = sno==null?null:new String(sno);
		user.setSno(sno);
  		//sex
  		String sex = request.getParameter("sex"); 	
  		sex = sex==null?null:new String(sex);
  		user.setSex(sex);
  		//name
  		String name = request.getParameter("name"); 	
  		name = name==null?null:new String(name);
  		user.setName(name);
	  	//dno
  		String dno = request.getParameter("dno"); 
  		dno = dno==null?null:new String(dno);
  		user.setDno(dno);
  		
	  	//tno
  		String tno = request.getParameter("tno"); 	
  		tno = tno==null?null:new String(tno);
  		user.setTno(tno);
	  	 //tel
  		String tel = request.getParameter("tel"); 	
  		tel = tel==null?null:new String(tel);
  		user.setTel(tel);
  		
  				
  		
        /**
        *执行update操作
        */
		 
        String update=request.getParameter("update");
        
        if(update!=null){
        		 if(StuOperation.isUpdate(user)){
        	          out.println("<script type=\"text/javascript\">");
        	          out.println("alert(\"修改成功！\");");
        	          out.println("open(\"student.jsp\",\"_self\");");
        	          out.println("</script>");
        	        }
        	        else{
        	          out.println("<script type=\"text/javascript\">");
        			  out.println("alert(\"修改失败！自动返回!\");");
        			  out.println("open(\"student.jsp\",\"_self\");");
        			  out.println("</script>");
        			  
        		
        	}
        }
        
    /**
       * 如果action是delete则是删除操作
       */
        String action =request.getParameter("action");
       if(action!=null){
            if(action.equals("delete")){
                if(StuOperation.isDelete(user)){
                 out.println("<script type=\"text/javascript\">");
        	          out.println("alert(\"删除成功！\");");
        	          out.println("open(\"student.jsp\",\"_self\");");
        	          out.println("</script>");
                }   
                else {
                      out.println("<script type=\"text/javascript\">");
        	          out.println("alert(\"删除失败！\");");
        	          out.println("open(\"student.jsp\",\"_self\");");
        	          out.println("</script>");
                }         
            }   
            return;   
        }
   
		  /*
		  *设置action隐藏控件的值
		  */
		  pageContext.setAttribute("update",action);
		  pageContext.setAttribute("sno",sno);
		  pageContext.setAttribute("sex",sex);
		  pageContext.setAttribute("name",name);
		  pageContext.setAttribute("tno",tno);
		  pageContext.setAttribute("dno",dno);
       	  pageContext.setAttribute("tel",tel);
         %>

  </head>
  
  <body>
  <div id="update">
 <!--  <img  src="./images/update.png" style="width:100%;height:100%;position:absolute;"> -->
  	<form action="studentupdate.jsp"  id="updateform" style="position:relative;">
  	<img  src="./images/update.png" style="width:100%;height:100%;position:absolute;">
 	 <table  id="updatetable" >
  <tr>
  <td><input type="hidden" name="update" value="${pageScope.update}"></td>
  </tr>
 <tr>
  <td>学生学号:</td>
  <td><input id="sno" type="text" name="sno" value="${pageScope.sno}"></td>
  </tr>
  <tr>
  <td>学生性别:</td>
  <td><input id="sex" type="text" name="sex" value="${pageScope.sex}"></td>
  </tr>
  <tr>
  <td>学生姓名:</td>
  <td><input id="name" type="text" name="name" value="${pageScope.name}"></td>
  </tr>
   <tr>
  <td>宿舍号:</td>
  <td><input  id="dno" type="text" name="dno" value="${pageScope.dno}"></td>
  </tr>
    <tr>
  <td>楼栋号:</td>
  <td><input id="tno" type="text" name="tno" value="${pageScope.tno}"></td>
  </tr>
   <tr>
  <td>电话号码:</td>
  <td><input id="tel" type="text" name="tel" value="${pageScope.tel}"></td>
  </tr>
  <tr>
  <td align="center"><input type="submit" value="提交" ></td>
  </tr>
  </table>
  </form>
  </div>
   
  </body>
</html>
