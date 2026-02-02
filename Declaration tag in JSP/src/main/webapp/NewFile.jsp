<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int n=Integer.parseInt(request.getParameter("No")); %>
<%! int square(int n){
	return n*n;
}
%>
<h2>The Square of Number is: <%= square(n) %></h2>
</body>
</html>