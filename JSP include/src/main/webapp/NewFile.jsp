<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>This is the JSP 1 file</h1>
<jsp:include page="Index2.jsp">
<jsp:param value="Unmesh" name="uname"/>
</jsp:include>
</body>
</html>