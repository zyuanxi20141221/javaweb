<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>接收请求头/请求参数</title>
</head>
<body>
<%
    Enumeration<String> headerNames = request.getHeaderNames();
    while(headerNames.hasMoreElements()){
    	String headName = headerNames.nextElement();
    	out.println(headName + "--->" + request.getHeader(headName) + "<br/>");
    }
    out.println("<hr/>");
    request.setCharacterEncoding("gb2312");
    
    String name = request.getParameter("name");
    String gender = request.getParameter("gender");
    String color = request.getParameter("color");
    String country = request.getParameter("country");
    
    
%>

<title>获取请求头/请求参数</title>
</head>
<body>
<% 
  request.setCharacterEncoding("utf-8");
  out.println("<hr/>");
  String _name = request.getParameter("name");
  String _gender = request.getParameter("gender");
  String[] _color = request.getParameterValues("color");
  String _country = request.getParameter("country");
%>
您的姓名:<%=_name %><br/>
您的性别：<%=_gender %><br/>
您喜欢的颜色：<%for(String c : _color){
	out.println(c +  " ");}%><br/>
您来自的国家：<%=_country %>
</body>
</html>