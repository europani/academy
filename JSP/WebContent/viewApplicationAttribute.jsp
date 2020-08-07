<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	Enumeration<String> attrEnum = application.getAttributeNames();
	while (attrEnum.hasMoreElements()) {
		String name = attrEnum.nextElement();
		Object value = application.getAttribute(name);
%>
application 속성 : <b><%=name %></b> = <%=value %><br>
<% } %>
</body>
</html>