<%@page import="com.db.StoreyOperation"%>
<%@page import="com.entity.Storey"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加楼栋信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="main.css">
	<script type="text/javascript">
	function check(){
		var tno=document.getElementById("tno").value;
		if(tno==""){
		alert("楼栋号不能为空！");
		return false;
		}
	var tname=document.getElementById("tname").value;
	if(tname==""){
	alert("楼栋名不能为空！");
	return false;
	}
	var tmanager=document.getElementById("tmanager").value;
	if(tmanager==""){
	alert("楼栋管理员不能为空！");
	return false;
	}
	
	}
	</script>
	<%
  		/*
  		 * 初始化一个Storey对象
  		 */ 
  		Storey user = new Storey();
	  		
	//tno
		String tno = request.getParameter("tno"); 	
		tno = tno==null?null:new String(tno);
		user.setTno(tno);
	  	 //tname
  		String tname = request.getParameter("tname"); 	
  		tname = tname==null?null:new String(tname);
  		user.setTname(tname); 		
  		// System.out.println(tno);
  	   //tmanager
  		String tmanager = request.getParameter("tmanager"); 	
  		tmanager = tmanager==null?null:new String(tmanager);
  		user.setTmanager(tmanager);
        /**
        *执行update操作
        */
		 
        String update=request.getParameter("update");
        
        if(update!=null){
        		 if(StoreyOperation.isUpdate(user)){
        	          out.println("<script type=\"text/javascript\">");
        	          out.println("alert(\"修改成功！\");");
        	          out.println("open(\"storey.jsp\",\"_self\");");
        	          out.println("</script>");
        	        }
        	        else{
        	          out.println("<script type=\"text/javascript\">");
        			  out.println("alert(\"修改失败！自动返回！!\");");
        			  out.println("open(\"storey.jsp\",\"_self\");");
        			  out.println("</script>");
        			  
        		
        	}
        }
        
    /**
       * 如果action是delete则是删除操作
       */
        String action =request.getParameter("action");
       if(action!=null){
            if(action.equals("delete")){
                if(StoreyOperation.isDelete(user)){
                 out.println("<script type=\"text/javascript\">");
        	          out.println("alert(\"删除成功！\");");
        	          out.println("open(\"storey.jsp\",\"_self\");");
        	          out.println("</script>");
                }   
                else {
                      out.println("<script type=\"text/javascript\">");
        	          out.println("alert(\"删除失败！\");");
        	          out.println("open(\"storey.jsp\",\"_self\");");
        	          out.println("</script>");
                }         
            }   
            return;   
        }
   
		  /*
		  *设置action隐藏控件的值
		  */
		  pageContext.setAttribute("update",action);
		  pageContext.setAttribute("tno",tno);
		  pageContext.setAttribute("tname",tname);
		  
		  pageContext.setAttribute("tmanager",tmanager);
       
         %>

  </head>
  
  <body>
    <div id="update">
    <form action="storeyupdate.jsp"  id="updateform" style="position:relative;">
    	<img  src="./images/update.png" style="width:100%;height:100%;position:absolute;">
  
  <table id="updatetable">
  <tr>
  <td><input type="hidden" name="update" value="${pageScope.update}"></td>
  
  </tr>
   <tr>
  <td>楼栋号:</td>
  <td><input id="tno" type="text" name="tno" value="${pageScope.tno}"></td>
  </tr>
  <tr>
  <td>楼栋名:</td>
  <td><input id="tname" type="text" name="tname" value="${pageScope.tname}"></td>
  </tr>
   <tr>
  <td>楼栋管理员:</td>
  <td><input id="tmanager" type="text" name="tmanager" value="${pageScope.tmanager}"></td>
  </tr> 
  <tr>
  <td align="center"><input type="submit" value="提交"></td>
  </tr>
  </table>
  </form>
   </div>
  </body>
</html>
