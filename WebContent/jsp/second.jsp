<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>request处理</title>
</head>
<body>
<%
   String bal = request.getParameter("balance");
   Double qian = Double.parseDouble(bal);
   
   List<String> info = (List<String>)request.getAttribute("info");
   
   for(String str : info){
	   out.println(str + "<br/>");
   }
   out.println("取钱：" + qian + "块");
   out.println("账户减少：" + qian);
%>
</body>
</html>