<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<h2>Formatting Tags3</h2>
<c:set var="dayTime" value="<%=new Date() %>" />
<fmt:formatDate value="${dayTime }" type="date" dateStyle="full"/><br>
<fmt:formatDate value="${dayTime }" type="time"/><br>

<fmt:timeZone value="Europe/London">
	Europe/London : <fmt:formatDate value="${dayTime}" type="both" dateStyle="full" timeStyle="full"/><br>
</fmt:timeZone>
<fmt:setTimeZone value="America/New_York" />
	America/New_York : <fmt:formatDate value="${dayTime}" type="both" dateStyle="full" timeStyle="full"/><br>
</body>
</html>