<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("euc-kr");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
</head>
<body>
<h1>Forward Tag Example1</h1>
Forward Tag의 포워딩 전의 페이지입니다.
<jsp:forward page="forwardTag1_2.jsp" />
</body>
</html>