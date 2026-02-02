<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="circleEx.Circle" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String r=request.getParameter("radius"); 
if(r!=null){
	int radius=Integer.parseInt(r);
	double result=Circle.area(radius);
%>
<h2>Area of Circle is <%= result %></h2>
<%
}
%>
</body>
</html>