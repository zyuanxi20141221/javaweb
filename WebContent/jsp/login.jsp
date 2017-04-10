<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<<<<<<< HEAD
=======
<%@ taglib prefix="s" uri="/struts-tags"%>
>>>>>>> 58efcc6315c8c1399eafd07a0934bc2d3567d358
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<<<<<<< HEAD
<title>用户登录</title>
</head>
<body>
<span style="clolor:red;font-weight:bold">
<%
   if(request.getParameter("err")!=null){
	   out.println(request.getParameter("err") + "<br/>");
   }
%>
</span>
请输入用户名和密码：
<form id="login" method = "post" action="/javaweb/login">
用户名：<input type="text" name="username"><br/>
密&nbsp;&nbsp;码：<input type="password" name="pass"><br/>
<input type="submit" value="登录">
</form>
=======
<title>login</title>
</head>
<body>
<s:form action="login" method="post">
   <s:textfield name="username" key="login.user"/>
   <s:textfield name="password" key="login.pass"/>
   <s:submit key="login.login"/>
</s:form>
>>>>>>> 58efcc6315c8c1399eafd07a0934bc2d3567d358
</body>
</html>