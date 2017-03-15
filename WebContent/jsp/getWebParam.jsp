<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="error.jsp"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>application获取初始化参数</title>
</head>
<body>
  <%
    //注册数据库驱动
    Class.forName(application.getInitParameter("driver"));
    //获取数据库连接
    Connection conn = DriverManager.getConnection(application.getInitParameter("url"),application.getInitParameter("user"),"root");
    //创建Statement
    Statement stmt = conn.createStatement();
    //执行查询
    ResultSet rs = stmt.executeQuery("select * from emp limit 0,10");
%>
<table width="300px" border="1" bgcolor="#9999dd">
<%
  //遍历结果集
  while(rs.next())
  {%>
  <tr>
      <!-- 输出结果集 -->
      <td><%=rs.getString(1) %></td>
      <td><%=rs.getString(2) %></td>
      <td><%=rs.getString(3) %></td>
      <td><%=rs.getString(4) %></td>
  </tr>
  <%} %>
</table>
</body>
</html>