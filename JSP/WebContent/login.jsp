<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String id = request.getParameter("memberId");
	if (id != null && id.equals("madvirus")) {
		response.sendRedirect("/jsp/index.jsp");
	}
	else {
%>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
잘못된 아이디입니다.
</body>
</html>
<% }
%>