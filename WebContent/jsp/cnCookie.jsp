<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>中文cookie</title>
</head>
<body>
<%
    Cookie c = new Cookie("cnCookie",URLEncoder.encode("孙悟空", "gbk"));
    c.setMaxAge(24*3600);
    response.addCookie(c);
    
    Cookie[] cookies = request.getCookies();
    for(Cookie cookie : cookies){
    	if(cookie.getName().equals("cnCookie")){
    		out.println(URLDecoder.decode(cookie.getValue(), "gbk"));
    	}
    }
%>
</body>
</html>