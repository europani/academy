<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String[] str1 = {"simba", "rorod", "tina", "poli"};
	String str2 = "JAVA, jsp; Spring, Android";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Core Tages3</h2>
<c:set var="arr" value="<%=str1%>" />
<c:forEach var="i" items="${arr}" begin="0" step="1" end="3">
	${i}<br>
</c:forEach>
<hr align="left" width="220">

<c:set var="s" value="<%=str2%>" />
<c:forTokens var="st" items="${s}" delims=", ;">
	${st}<br>
</c:forTokens>
</body>
</html>