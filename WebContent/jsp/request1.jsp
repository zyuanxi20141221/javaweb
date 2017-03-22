<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>获取请求头/请求参数</title>
</head>
<body>
<% 
  request.setCharacterEncoding("utf-8");
  out.println("<hr/>");
  String name = request.getParameter("name");
  String gender = request.getParameter("gender");
  String[] color = request.getParameterValues("color");
  String country = request.getParameter("country");
%>
您的姓名:<%=name %><br/>
您的性别：<%=gender %><br/>
您喜欢的颜色：<%for(String c : color){
	out.println(c +  " ");}%><br/>
您来自的国家：<%=country %>
</body>
</html>