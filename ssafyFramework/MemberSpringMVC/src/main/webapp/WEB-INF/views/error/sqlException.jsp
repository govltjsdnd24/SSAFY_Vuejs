<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<div align="center">
		<h1>sql Exception!</h1>
		<h2>왜 그랬니</h2>
		${message }<br/>
		 <a href="<c:url value='/'/>">초기화면</a>
	</div>
</body>
</html>