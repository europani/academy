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
		Enumeration headerEnum = request.getHeaderNames();
		while (headerEnum.hasMoreElements()) {
			String headerName = (String) headerEnum.nextElement();
			String headerValue = request.getHeader(headerName);
	%>
	<%=headerName%>
	=
	<%=headerValue%>
	<br>
	<%
		}
	%>
</body>
</html>