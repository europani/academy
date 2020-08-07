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
초기화 파라미터 목록 : 
<ul>
<%
	Enumeration<String> initParamEnum = application.getInitParameterNames();
	while (initParamEnum.hasMoreElements()) {
		String initParamName = initParamEnum.nextElement();
	
%>
<li> <%=initParamName %> = <%=application.getInitParameter(initParamName) %>
</li>
<%
	}
%>
</ul>
</body>
</html>