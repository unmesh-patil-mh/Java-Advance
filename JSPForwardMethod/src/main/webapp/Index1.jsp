<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to index1 JSP</h1>
<jsp:forward page="Index2.jsp">
<jsp:param value="Unmesh" name="unmae"/>
</jsp:forward>
</body>
</html>