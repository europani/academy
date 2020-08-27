<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<String> li = new ArrayList<String>();
	li.add("aaa1");
	li.add("aaa2");
	li.add("aaa3");
	li.add("aaa4");
	li.add("aaa5");
	li.add("aaa6");
	li.add("aaa7");
	li.add("aaa8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>List</h4>
<c:set var="li" value=<%=li%> />
<c:forEach var="i" items="${li}" varStatus="status">
	${status.index } : ${status.count } - ${i}<br>
</c:forEach>
</body>
</html>