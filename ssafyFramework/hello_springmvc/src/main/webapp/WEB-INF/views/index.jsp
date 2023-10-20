<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Spring MVC !!!</h1>
	<a href="${root}/basic/hello1">Hello1 Spring</a><br>
	<a href="${root}/basic/hello2">Hello2 Spring</a><br>
	<a href="${root}/param/single/">Single Parameter Test</a><br>
	<a href="${root}/param/multi">Multiple Parameters Test</a><br>
</body>
</html>