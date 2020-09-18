<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
    String memberId = request.getParameter("memberId");
	session.setAttribute("MEMBER", memberId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인</title>
</head>
<body>
로그인 처리
</body>
</html>