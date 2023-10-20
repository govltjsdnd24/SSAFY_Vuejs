<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="left">
<c:choose>
	<c:when test="${data.fruit eq null}">
		${data.username}님의 아이디는 : (${data.userid}) 이며, 거주하는 지역의 index는 ${data.area} 입니다.
	</c:when>
	<c:otherwise>
		${data.username}(${data.userid})님이 좋아하는 과일은
		<c:set var="len" value="${data.fruit.size()}"/>
		<c:forEach varStatus="idx" var="fruit" items="${data.fruit}">
		${fruit}<c:if test="${idx.index ne len - 1 }">, </c:if>
		</c:forEach>입니다.
	</c:otherwise>
</c:choose>
</div>
</body>
</html>