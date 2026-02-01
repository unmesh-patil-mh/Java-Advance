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
<%! int factorial(int n){
	int fact=1;
	while(n>0){
		fact=fact*n;
		n--;
	}
	return fact;
}
%>

<h2>The Factorial of Number is: <%= factorial(n) %></h2>
</body>
</html>