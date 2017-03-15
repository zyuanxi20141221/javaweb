<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Bean测试</title>
</head>
<body>
    <!-- 创建实例 -->
	<jsp:useBean id="p1" class="lee.Person" scope="page" />
	<!-- 设置p1的name属性值 -->
    <jsp:setProperty property="name" name="p1" value="john"/>
    <!-- 设置p1的age属性值 -->
    <jsp:setProperty property="age" name="p1" value="29"/>
    <!-- 获取p1的name属性值 -->
    <jsp:getProperty property="name" name="p1"/><br/>
    <!-- 获取p1的age属性值 -->
    <jsp:getProperty property="age" name="p1"/>
</body>
</html>