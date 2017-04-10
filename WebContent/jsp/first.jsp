<%@page import="java.util.ArrayList"%>
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
    if(qian < 500){
    	out.println("给你" + qian + "块");
    	out.println("账户减少:" +  qian);
    }
    else {
    	List<String> list = new ArrayList<String>();
    	list.add("111");
    	list.add("222");
    	list.add("333");
    	request.setAttribute("info", list);
%>
  <jsp:forward page="second.jsp" />
<%} %>
</body>
</html>