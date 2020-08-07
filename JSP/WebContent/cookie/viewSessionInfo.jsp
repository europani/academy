<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>세션 확인</title>
</head>
<body>
<%
	Enumeration en = session.getAttributeNames();	// 세션 key
	while (en.hasMoreElements()) {
		String name = (String)en.nextElement();
		String value = (String)session.getAttribute(name);
		out.println("session name : " + name + "<br>");
		out.println("session value : " + value + "<br>");
	}

%>
</body>
</html>