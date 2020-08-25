<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("siteName", "JSPStudy.co.kr");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expression language</title>
</head>
<body>
사이트명 : <b>${siteName}</b>
</body>
</html>